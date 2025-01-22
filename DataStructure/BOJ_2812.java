// BOJ - 2812
// Problem Sheet - https://www.acmicpc.net/problem/2812

import java.util.*;
import java.io.*;

public class Main {

    private static int N, K;
    private static String value;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        N = Integer.parseInt(row[0]);
        K = Integer.parseInt(row[1]);
        value = br.readLine();
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>(N);
        for (int i=0 ; i<N ; i++) {
            while (!stack.isEmpty() && stack.peekLast() < value.charAt(i) && K > 0) {
                stack.pollLast();
                K--;
            }
            stack.addLast(value.charAt(i));
        }
        while (K > 0) {
            stack.pollLast();
            K--;
        }
        stack.forEach(sb::append);
        return sb.toString();
    }
}