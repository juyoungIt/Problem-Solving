// BOJ - 1766
// Problem Sheet - https://www.acmicpc.net/problem/1766

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] row = br.readLine().split(" ");
        int n = Integer.parseInt(row[0]);
        int m = Integer.parseInt(row[1]);
        List<Integer>[] al = new LinkedList[n + 1];
        int[] indegree = new int[n + 1];
        for (int i=1 ; i<=n ; i++) {
            al[i] = new LinkedList<>();
        }
        for (int i=0 ; i<m ; i++) {
            row = br.readLine().split(" ");
            int a = Integer.parseInt(row[0]);
            int b = Integer.parseInt(row[1]);
            al[a].add(b);
            indegree[b]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i=1 ; i<=n ; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");
            for (int p : al[cur]) {
                indegree[p]--;
                if (indegree[p] == 0) {
                    queue.add(p);
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}