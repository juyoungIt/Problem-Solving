// BOJ - 8594
// Problem Sheet - https://www.acmicpc.net/problem/8594

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static String message;
    private static final String INVALID = "NIE";

    public static void main(String[] args) throws IOException {
        input();
        int result = solve();
        System.out.println(result < 0 ? INVALID : result);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        message = br.readLine();
        br.close();
    }

    private static int solve() {
        Deque<Character> stack = new ArrayDeque<>();
        int maxDepth = 0;
        for (int i=0 ; i<n ; i++) {
            char c = message.charAt(i);
            if (isOpenParenthesis(c)) {
                stack.push(c);
                maxDepth = Math.max(maxDepth, stack.size());
            } else {
                if (stack.isEmpty()) return -1;
                char top = stack.pop();
                if (!isValidPair(top, c)) return -1;
            }
        }
        return !stack.isEmpty() ? -1 : maxDepth;
    }

    private static boolean isOpenParenthesis(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private static boolean isValidPair(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '{' && close == '}')
                || (open == '[' && close == ']');
    }

}