// BOJ - 17287
// Problem Sheet - https://www.acmicpc.net/problem/17287

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        int maxValue = 0;
        int value = 0;
        for (char digit : input) {
            if (isOpenParenthesis(digit)) {
                value += getValue(digit);
            } else if (isCloseParenthesis(digit)) {
                value -= getValue(digit);
            } else {
                if (maxValue < value) {
                    maxValue = value;
                }
            }
        }

        System.out.println(maxValue);

        br.close();
        System.exit(0);
    }

    private static boolean isOpenParenthesis(char digit) {
        return digit == '(' || digit == '{' || digit == '[';
    }

    private static boolean isCloseParenthesis(char digit) {
        return digit == ')' || digit == '}' || digit == ']';
    }

    private static int getValue(char digit) {
        if (digit == '(' || digit == ')') return 1;
        else if (digit == '{' || digit == '}') return 2;
        else return 3;
    }
}