// BOJ - 10829
// Problem Sheet - https://www.acmicpc.net/problem/10829

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long n = Long.parseLong(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        while (n > 0) {
            stack.push((int)(n % 2));
            n /= 2;
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
        br.close();
    }
}
