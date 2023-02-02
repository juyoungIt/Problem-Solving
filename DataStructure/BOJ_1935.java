// BOJ - 1935
// Problem Sheet - https://www.acmicpc.net/problem/1935

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();
        Map<Character, Double> valueMapper = new HashMap<>();

        int n = Integer.parseInt(bf.readLine()); // 피연산자의 갯수
        char[] expression = bf.readLine().toCharArray();
        for(int i=1 ; i<=n ; i++) {
            valueMapper.put((char)(64+i), Double.parseDouble(bf.readLine()));
        }

        double operand1;
        double operand2;
        for(char element : expression) {
            if(isOperator(element)) { // 연산자인 경우
                operand1 = stack.pop();
                operand2 = stack.pop();
                if(element == '+') {
                    stack.push(operand2 + operand1);
                } else if(element == '-') {
                    stack.push(operand2 - operand1);
                } else if(element == '*') {
                    stack.push(operand2 * operand1);
                } else {
                    stack.push(operand2 / operand1);
                }
            } else { // 피연산자인 경우
                stack.push(valueMapper.get(element));
            }
        }

        System.out.printf("%.2f", stack.pop());

        bf.close();
        System.exit(0);
    }

    static boolean isOperator(char element) {
        return element == '+' || element == '-' || element == '*' || element == '/';
    }
}