// BOJ - 1516
// Problem Sheet - https://www.acmicpc.net/problem/1516

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] bt = new int[n + 1];
        int[] dp = new int[n + 1];
        int[] indegree = new int[n + 1];
        List<Integer>[] al = new ArrayList[n + 1];
        for (int i=1 ; i<=n ; i++) {
            al[i] = new ArrayList<>();
        }
        for (int i=1 ; i<=n ; i++) {
            String[] row = br.readLine().split(" ");
            bt[i] = Integer.parseInt(row[0]);
            for (int j=1 ; j<row.length ; j++) {
                int b = Integer.parseInt(row[j]);
                if (b == -1) break;
                al[b].add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=1 ; i<=n ; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                dp[i] = bt[i];
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int b : al[cur]) {
                dp[b] = Math.max(dp[b], dp[cur] + bt[b]);
                indegree[b]--;
                if (indegree[b] == 0) {
                    queue.add(b);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1 ; i<=n ; i++) {
            sb.append(dp[i]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}