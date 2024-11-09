// BOJ - 1935
// Problem Sheet - https://www.acmicpc.net/problem/1935

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] expression = br.readLine().toCharArray();
        int[] operands = new int[N];
        for (int i=0 ; i<N ; i++) {
            operands[i] = Integer.parseInt(br.readLine());
        }

        Deque<Double> stack = new ArrayDeque<>(N);
        for (char element : expression) {
            if (isOperator(element)) {
                switch (element) {
                    case '+':
                        double operandA = stack.pop();
                        double operandB = stack.pop();
                        stack.push(operandB + operandA);
                        break;
                    case '-':
                        operandA = stack.pop();
                        operandB = stack.pop();
                        stack.push(operandB - operandA);
                        break;
                    case '*':
                        operandA = stack.pop();
                        operandB = stack.pop();
                        stack.push(operandB * operandA);
                        break;
                    case '/':
                        operandA = stack.pop();
                        operandB = stack.pop();
                        stack.push(operandB / operandA);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
                continue;
            }
            stack.push((double) operands[(element - 'A')]);
        }

        System.out.printf("%.2f\n", stack.pop());
        br.close();
    }

    private static boolean isOperator(char element) {
        return element == '+' || element == '-' || element == '*' || element == '/';
    }
}