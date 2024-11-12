// BOJ - 6198
// Problem Sheet - https://www.acmicpc.net/problem/6198

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();

        long answer = 0;
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int h = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= h) {
                stack.pop();
            }
            stack.push(h);
            answer += stack.size() - 1;
        }

        System.out.println(answer);
        br.close();
    }
}