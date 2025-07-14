// BOJ - 11286
// Problem Sheet - https://www.acmicpc.net/problem/11286

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((e1, e2) -> {
            int abs1 = Math.abs(e1);
            int abs2 = Math.abs(e2);
            if (abs1 == abs2) return e1 - e2;
            return abs1 - abs2;
        });
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) sb.append(pQueue.isEmpty() ? 0 : pQueue.poll()).append("\n");
            else pQueue.add(x);
        }

        System.out.println(sb);
        br.close();
    }
}