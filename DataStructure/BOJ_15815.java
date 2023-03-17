// BOJ - 15815
// Problem Sheet - https://www.acmicpc.net/problem/15815

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();

        String[] expressionElements = bf.readLine().split("");
        int operandA, operandB;
        for(String element : expressionElements) {
            if(Character.isDigit(element.charAt(0))) {
                stack.push(element);
            } else { // is operator
                operandB = Integer.parseInt(stack.pop());
                operandA = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(calculate(operandA, operandB, element)));
            }
        }

        System.out.println(stack.pop());

        bf.close();
        System.exit(0);
    }

    static int calculate(int operandA, int operandB, String operator) {
        switch (operator) {
            case "+": return operandA + operandB;
            case "-": return operandA - operandB;
            case "*": return operandA * operandB;
            default: return operandA / operandB;
        }
    }
}