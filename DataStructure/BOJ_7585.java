// BOJ - 7585
// Problem Sheet - https://www.acmicpc.net/problem/7585

import java.util.*;
import java.io.*;

public class Main {

    enum Result {
        Legal, Illegal
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String code = br.readLine();
            if (code.equals("#")) break;
            sb.append(isValid(code) ? Result.Legal : Result.Illegal).append("\n");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static boolean isValid(String code) {
        boolean isValid = true;
        Stack<Character> stack = new Stack<>();
        for (int i=0 ; i<code.length() ; i++) {
            char token = code.charAt(i);
            if (isBracket(token) && isOpenBracket(token)) {
                stack.push(token);
            }
            if (isBracket(token) && isCloseBracket(token)) {
                Character bracket = stack.peek();
                if (isValidPair(bracket, token)) {
                    stack.pop();
                } else {
                    isValid = false;
                    break;
                }
            }
        }
        if (!stack.isEmpty()) {
            isValid = false;
        }
        return isValid;
    }

    private static boolean isBracket(char c) {
        return c == '('
                || c == '{'
                || c == '['
                || c == ')'
                || c == '}'
                || c == ']';
    }

    private static boolean isOpenBracket(char bracket) {
        return bracket == '('
                || bracket == '{'
                || bracket == '[';
    }

    private static boolean isCloseBracket(char bracket) {
        return bracket == ')'
                || bracket == '}'
                || bracket == ']';
    }

    private static boolean isValidPair(char openBracket, char closeBracket) {
        return openBracket == '(' && closeBracket == ')'
                || openBracket == '{' && closeBracket == '}'
                || openBracket == '[' && closeBracket == ']';
    }
}