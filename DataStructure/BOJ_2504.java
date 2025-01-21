// BOJ - 2504
// Problem Sheet - https://www.acmicpc.net/problem/2504

import java.util.*;
import java.io.*;

public class Main {

    private static String[] letters;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        letters = br.readLine().split("");
        br.close();
    }

    private static int solve() {
        int totalSum = 0;
        Stack<String> stack = new Stack<>();
        for (String letter : letters) {
            if (isOpen(letter.charAt(0))) {
                stack.push(letter);
            } else {
                if (stack.isEmpty()) return 0;
                int innerSum = 0;
                while (!stack.isEmpty()) {
                    String top = stack.pop();
                    if (isNumeric(top)) {
                        innerSum += Integer.parseInt(top);
                    } else {
                        int matchedCode = isMatched(top.charAt(0), letter.charAt(0));
                        if (matchedCode < 0) return 0;
                        innerSum = Math.max(innerSum, 1);
                        innerSum *= matchedCode;
                        stack.push(Integer.toString(innerSum));
                        break;
                    }
                }
                if (stack.empty()) return 0;
            }
        }

        while (!stack.isEmpty()) {
            String top = stack.pop();
            if (!isNumeric(top)) {
                return 0;
            }
            totalSum += Integer.parseInt(top);
        }
        return totalSum;
    }

    private static boolean isOpen(char letter) {
        return letter == '(' || letter == '[';
    }

    private static int isMatched(char open, char close) {
        if (open == '(' && close == ')' || open == '[' && close == ']') {
            if (open == '(') return 2;
            else return 3;
        }
        return -1;
    }

    private static boolean isNumeric(String str) {
        for (int i=0; i<str.length() ; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}