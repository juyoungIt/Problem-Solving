// BOJ - 9492
// Problem Sheet - https://www.acmicpc.net/problem/9492

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            int topSize = n % 2 == 0 ? n / 2 : n / 2 + 1;
            Deque<String> top = new ArrayDeque<>(topSize);
            Deque<String> bottom = new ArrayDeque<>(n / 2);
            for (int i=0 ; i<topSize ; i++) top.addLast(br.readLine());
            for (int i=0 ; i<n/2 ; i++) bottom.addLast(br.readLine());
            while (!top.isEmpty()) {
                sb.append(top.pollFirst()).append("\n");
                if (!bottom.isEmpty()) sb.append(bottom.pollFirst()).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}