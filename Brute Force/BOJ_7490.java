// BOJ - 7490
// Problem Sheet - https://www.acmicpc.net/problem/7490

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static final List<String> exprList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            solve(2, "1");
            Collections.sort(exprList);
            for (String expr : exprList) {
                sb.append(expr).append("\n");
            }
            exprList.clear();
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void solve(int number, String expr) {
        if (number == N + 1) {
            if (getSum(expr) == 0) {
                exprList.add(expr);
            }
            return;
        }
        for (int i=0 ; i<3 ; i++) {
            if (i == 0) solve(number + 1, expr + "+" + number);
            else if (i == 1) solve(number + 1, expr + "-" + number);
            else solve(number + 1, expr + " " + number);
        }
    }

    private static int getSum(String expr) {
        expr = expr.replaceAll(" ", "");
        StringBuilder buffer = new StringBuilder();
        Deque<Integer> operands = new ArrayDeque<>();
        Deque<Character> operators = new ArrayDeque<>();
        for (int i=0 ; i<expr.length() ; i++) {
            if (Character.isDigit(expr.charAt(i))) {
                buffer.append(expr.charAt(i));
            } else {
                operands.addLast(Integer.parseInt(buffer.toString()));
                buffer.setLength(0);
                operators.addLast(expr.charAt(i));
            }
        }
        operands.addLast(Integer.parseInt(buffer.toString()));
        while (!operators.isEmpty()) {
            char operator = operators.pollFirst();
            if (operator == '+') {
                operands.addFirst(operands.pollFirst() + operands.pollFirst());
            } else {
                operands.addFirst(operands.pollFirst() - operands.pollFirst());
            }
        }
        return operands.pollFirst();
    }
}