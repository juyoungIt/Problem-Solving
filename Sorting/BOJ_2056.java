// BOJ - 2056
// Problem Sheet - https://www.acmicpc.net/problem/2056

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] pt = new int[n + 1];
        int[] dp = new int[n + 1];
        int[] indegree = new int[n + 1];
        List<Integer>[] al = new ArrayList[n + 1];
        for (int i=1 ; i<=n ; i++) {
            al[i] = new ArrayList<>();
        }
        for (int i=1 ; i<=n ; i++) {
            String[] row = br.readLine().split(" ");
            pt[i] = Integer.parseInt(row[0]);
            int pc = Integer.parseInt(row[1]);
            for (int j=2 ; j<2+pc ; j++) {
                int p = Integer.parseInt(row[j]);
                al[p].add(i);
                indegree[i]++;
            }
        }

        int finishTime = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1 ; i<=n ; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                dp[i] = pt[i];
                finishTime = Math.max(finishTime, dp[i]);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int p : al[cur]) {
                dp[p] = Math.max(dp[p], dp[cur] + pt[p]);
                finishTime = Math.max(finishTime, dp[p]);
                indegree[p]--;
                if (indegree[p] == 0) {
                    queue.add(p);
                }
            }
        }

        System.out.println(finishTime);
        br.close();
    }
}