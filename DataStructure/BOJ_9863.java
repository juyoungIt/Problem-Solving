// BOJ - 9863
// Problem Sheet - https://www.acmicpc.net/problem/9863

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] row = br.readLine().split(" ");
            int n = Integer.parseInt(row[0]);
            int m = Integer.parseInt(row[1]);
            int k = Integer.parseInt(row[2]);
            if (n ==0 && m == 0 && k == 0) break;
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i=1 ; i<=n ; i++) {
                queue.add(i);
            }
            for (int i=1 ; i<=k ; i++) {
                for (int j=0 ; j<m-1 ; j++) {
                    queue.add(queue.poll());
                }
                int removed = queue.poll();
                if (i == k) {
                    sb.append(removed).append("\n");
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}