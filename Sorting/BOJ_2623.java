// BOJ - 2623
// Problem Sheet - https://www.acmicpc.net/problem/2623

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] row = br.readLine().split(" ");
        int n = Integer.parseInt(row[0]);
        int m = Integer.parseInt(row[1]);
        List<Integer>[] al = new ArrayList[n + 1];
        for (int i=1 ; i<=n ; i++) {
            al[i] = new ArrayList<>();
        }
        int[] indegree = new int[n + 1];
        boolean[] check = new boolean[n + 1];
        for (int i=0 ; i<m ; i++) {
            row = br.readLine().split(" ");
            int s = Integer.parseInt(row[0]);
            for (int j=2 ; j<=s ; j++) {
                int dept = Integer.parseInt(row[j - 1]);
                int dest = Integer.parseInt(row[j]);
                al[dept].add(dest);
                indegree[dest]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=1 ; i<=n ; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            check[cur] = true;
            sb.append(cur).append("\n");
            for (int v : al[cur]) {
                if (check[v]) continue;
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        if (!isFinished(check)) {
            System.out.println(0);
            return;
        }

        System.out.println(sb);
        br.close();
    }

    private static boolean isFinished(boolean[] check) {
        for (int i=1 ; i<check.length ; i++) {
            if (!check[i]) {
                return false;
            }
        }
        return true;
    }
}