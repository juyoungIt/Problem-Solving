// BOJ - 2637
// Problem Sheet - https://www.acmicpc.net/problem/2637

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] indegree = new int[n + 1];
        int[] counts = new int[n + 1];
        boolean[] isNotBasicParts = new boolean[n + 1];
        int[][] am = new int[n + 1][n + 1];
        for (int i=0 ; i<m ; i++) {
            String[] row = br.readLine().split(" ");
            int x = Integer.parseInt(row[0]);
            int y = Integer.parseInt(row[1]);
            int z = Integer.parseInt(row[2]);
            isNotBasicParts[x] = true;
            indegree[y]++;
            am[x][y] = z;
        }
        counts[n] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i=1 ; i<=n ; i++) {
                if (am[cur][i] == 0) continue;
                counts[i] += counts[cur] * am[cur][i];
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1 ; i<=n ; i++) {
            if (isNotBasicParts[i]) continue;
            sb.append(i).append(" ").append(counts[i]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}