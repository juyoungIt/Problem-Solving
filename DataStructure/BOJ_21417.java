// BOJ - 21417
// Problem Sheet - https://www.acmicpc.net/problem/21417

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String status = br.readLine();
        int k = Integer.parseInt(br.readLine());
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();
        for (int i=0 ; i<status.length() ; i++) {
            stack.push(status.charAt(i));
        }

        while (k-- > 0) {
            while (!stack.isEmpty()) {
                left.push(stack.pop());
                if (stack.isEmpty()) break;
                right.push(stack.pop());
            }
            while (!right.isEmpty()) {
                stack.push(right.pollLast());
            }
            while (!left.isEmpty()) {
                stack.push(left.pollLast());
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        System.out.println(sb);
        br.close();
    }
}