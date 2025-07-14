// BOJ - 1927
// Problem Sheet - https://www.acmicpc.net/problem/1927

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) sb.append(pQueue.isEmpty() ? 0 : pQueue.poll()).append("\n");
            else pQueue.add(x);
        }
        System.out.println(sb);
        br.close();
    }
}