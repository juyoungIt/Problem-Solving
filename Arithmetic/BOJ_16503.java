// BOJ - 16503
// Problem Sheet - https://www.acmicpc.net/problem/16503

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] operands = new int[3];
        char[] operators = new char[2];
        operands[0] = Integer.parseInt(st.nextToken());
        operators[0] = st.nextToken().charAt(0);
        operands[1] = Integer.parseInt(st.nextToken());
        operators[1] = st.nextToken().charAt(0);
        operands[2] = Integer.parseInt(st.nextToken());

        int resultA = calculate(calculate(operands[0], operands[1], operators[0]), operands[2], operators[1]);
        int resultB = calculate(operands[0], calculate(operands[1], operands[2], operators[1]), operators[0]);

        sb.append(Math.min(resultA, resultB));
        sb.append("\n");
        sb.append(Math.max(resultA, resultB));

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static int calculate(int operandA, int operandB, char operator) {
        if (operator == '+') {
            return operandA + operandB;
        } else if (operator == '-') {
            return operandA - operandB;
        } else if (operator == '*') {
            return operandA * operandB;
        } else {
            return operandA / operandB;
        }
    }
}