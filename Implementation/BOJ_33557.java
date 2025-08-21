// BOJ - 33557
// Problem Sheet - https://www.acmicpc.net/problem/33557

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] row = br.readLine().split(" ");
            long a = Long.parseLong(row[0]);
            long b = Long.parseLong(row[1]);
            String correct = Long.toString(a * b);
            Deque<Integer> stack = new ArrayDeque<>();
            while (a > 0 && b > 0) {
                int digitA = (int) (a % 10);
                int digitB = (int) (b % 10);
                stack.push(digitA * digitB);
                a /= 10;
                b /= 10;
            }
            while (a > 0) {
                stack.push((int) (a % 10));
                a /= 10;
            }
            while (b > 0) {
                stack.push((int) (b % 10));
                b /= 10;
            }
            StringBuilder wrong = new StringBuilder();
            while (!stack.isEmpty()) {
                wrong.append(stack.pop());
            }
            sb.append(correct.contentEquals(wrong) ? 1 : 0).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}