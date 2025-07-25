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
            List<Integer>[] al = new ArrayList[n + 1];
            for (int i=1 ; i<=n ; i++) {
                al[i] = new ArrayList<>();
            }
            String[] row = br.readLine().split(" ");
            int[] teams = new int[n + 1];
            int[] ranks = new int[n + 1];
            for (int i=1 ; i<=n ; i++) {
                teams[i] = Integer.parseInt(row[i - 1]);
                ranks[teams[i]] = i;
            }
            for (int i=1 ; i<=n ; i++) {
                for (int j=i+1 ; j<=n ; j++) {
                    al[teams[i]].add(teams[j]);
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
                    al[a].remove((Integer) b);
                    al[b].add(a);
                    indegree[a]++;
                    indegree[b]--;
                } else {
                    al[b].remove((Integer) a);
                    al[a].add(b);
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
                for (int team : al[cur]) {
                    indegree[team]--;
                    if (indegree[team] == 0) {
                        queue.add(team);
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

    private static boolean isFinished(boolean[] visited) {
        for (int i=1 ; i<visited.length ; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }

}