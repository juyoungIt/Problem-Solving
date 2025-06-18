// BOJ - 11322
// Problem Sheet - https://www.acmicpc.net/problem/11322

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(getDivisible(n)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static long getDivisible(int n) {
        Deque<Long> queue = new ArrayDeque<>();
        queue.add(1L);
        while (!queue.isEmpty()) {
            long cur = queue.poll();
            if (cur % n == 0) return cur;
            long base = cur * 10;
            queue.add(base);
            queue.add(base + 1);
        }
        return -1;
    }

}
