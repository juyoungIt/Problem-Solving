// BOJ - 10489
// Problem Sheet - https://www.acmicpc.net/problem/10489

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[] cards;
    private static Deque<Integer> stack;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cards = new int[n];
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            cards[i] = Integer.parseInt(row[i]);
        }
        stack = new ArrayDeque<>(n);
        br.close();
    }

    private static int solve() {
        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty() && (stack.peek() + cards[i]) % 2 == 0) {
                stack.pop();
            } else {
                stack.push(cards[i]);
            }
        }
        return stack.size();
    }
}