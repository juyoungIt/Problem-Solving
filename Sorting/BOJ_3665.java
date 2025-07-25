// BOJ - 3665
// Problem Sheet - https://www.acmicpc.net/problem/3665

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] indegree = new int[n + 1];
            boolean[][] am = new boolean[n + 1][n + 1];
            String[] row = br.readLine().split(" ");
            int[] teams = new int[n + 1];
            int[] ranks = new int[n + 1];
            for (int i=1 ; i<=n ; i++) {
                teams[i] = Integer.parseInt(row[i - 1]);
                ranks[teams[i]] = i;
            }
            for (int i=1 ; i<=n ; i++) {
                for (int j=i+1 ; j<=n ; j++) {
                    am[teams[i]][teams[j]] = true;
                    indegree[teams[j]]++;
                }
            }

            int m = Integer.parseInt(br.readLine());
            for (int i=0 ; i<m ; i++) {
                row = br.readLine().split(" ");
                int a = Integer.parseInt(row[0]);
                int b = Integer.parseInt(row[1]);
                int indexA = ranks[a];
                int indexB = ranks[b];
                if (indexA < indexB) {
                    am[a][b] = false;
                    am[b][a] = true;
                    indegree[a]++;
                    indegree[b]--;
                } else {
                    am[b][a] = false;
                    am[a][b] = true;
                    indegree[a]--;
                    indegree[b]++;
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            List<Integer> answer = new ArrayList<>();
            for (int i=1 ; i<=n ; i++) {
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }
            while (!queue.isEmpty()) {
                if (queue.size() > 1) {
                    sb.append("?");
                    break;
                }
                int cur = queue.poll();
                answer.add(cur);
                for (int i=1 ; i<=n ; i++) {
                    if (!am[cur][i]) continue;
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        queue.add(i);
                    }
                }
            }
            if (answer.size() < n) sb.append("IMPOSSIBLE");
            else for (int e : answer) sb.append(e).append(" ");
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

}