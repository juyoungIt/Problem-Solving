// BOJ - 30614
// Problem Sheet - https://acmicpc.net/problem/30614

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String containers = br.readLine();
        br.close();
        Deque<Character> stack = new ArrayDeque<>(n);
        for (int i=0; i<n; i++) {
            char c = containers.charAt(i);
            if (Character.isLowerCase(c)) {
                stack.addLast(c);
            } else {
                if (stack.isEmpty() || Character.toLowerCase(c) != stack.peekLast()) {
                    System.out.println(0);
                    return;
                }
                stack.pollLast();
            }
        }
        System.out.println(stack.isEmpty() ? 1 : 0);
    }
}
