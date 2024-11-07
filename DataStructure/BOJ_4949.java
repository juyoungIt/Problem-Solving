// BOJ - 4949
// Problem Sheet - https://www.acmicpc.net/problem/4949

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Character> stack = new ArrayDeque<>(100);
        while (true) {
            String input = br.readLine();
            boolean isFinished = false;
            if (input.equals(".")) break;
            for (char element : input.toCharArray()) {
                if (isParentheses(element)) {
                    if (isOpenParentheses(element)) {
                        stack.push(element);
                    } else {
                        if (stack.isEmpty() || !isValidPair(stack.peek(), element)) {
                            sb.append("no\n");
                            isFinished = true;
                            break;
                        }
                        stack.pop();
                    }
                }
            }
            if (!isFinished) {
                if (stack.isEmpty()) sb.append("yes\n");
                else sb.append("no\n");
            }
            stack.clear();
        }

        System.out.println(sb);
        br.close();
    }

    private static boolean isParentheses(char letter) {
        return letter == '(' || letter == ')' || letter == '[' || letter == ']';
    }

    private static boolean isOpenParentheses(char letter) {
        return letter == '(' || letter == '[';
    }

    private static boolean isValidPair(char letterA, char letterB) {
        return letterA == '(' && letterB == ')' || letterA == '[' && letterB == ']';
    }
}