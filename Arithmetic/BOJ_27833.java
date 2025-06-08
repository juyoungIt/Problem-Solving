// BOJ - 27833
// Problem Sheet - https://www.acmicpc.net/problem/27833

import java.util.*;
import java.io.*;

public class Main {

    private static int t;
    private static String[] exprs;
    private static final String UNKNOWN = "machula";
    private static final String EXPR_FORMAT = "%d + %d = %d";

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        exprs = new String[t];
        for (int i=0 ; i<t ; i++) {
            br.readLine(); // remove empty line
            exprs[i] = br.readLine();
        }
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        for (String expr : exprs) {
            String[] operands = expr.split(" \\+ | = ");
            int operandA, operandB, result;
            if (operands[0].contains(UNKNOWN)) {
                result = Integer.parseInt(operands[2]);
                operandB = Integer.parseInt(operands[1]);
                operandA = result - operandB;
            } else if (operands[1].contains(UNKNOWN)) {
                result = Integer.parseInt(operands[2]);
                operandA = Integer.parseInt(operands[0]);
                operandB = result - operandA;
            } else {
                operandA = Integer.parseInt(operands[0]);
                operandB = Integer.parseInt(operands[1]);
                result = operandA + operandB;
            }
            sb.append(String.format(EXPR_FORMAT, operandA, operandB, result)).append("\n");
        }
        return sb.toString();
    }

}