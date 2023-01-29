// BOJ - 2504
// Problem Sheet - https://www.acmicpc.net/problem/2504

import java.util.*;
import java.io.*;

public class Main {

    private static final int SMALL_PARENTHESES = 2;
    private static final int LARGE_PARENTHESES = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int totalValue = 0; // 괄호에 대한 값
        boolean isValid = true; // 입력된 문자열이 유효한 문자열인가?

        Stack<String> stack = new Stack<>();
        String[] parentheses = bf.readLine().split(""); // 입력 문자열
        for(String paren : parentheses) {
            if(paren.equals("[") || paren.equals("(")) { // 여는 괄호
                stack.add(paren);
            } else { // 닫는 괄호
                if(stack.isEmpty()) {
                    isValid = false;
                    break;
                }
                int partValue = 0; // 괄호 부분에 대한 값의 합
                boolean reachedPair = false;
                while(!stack.isEmpty()) {
                    if(stack.peek().equals(getPair(paren))) {
                        reachedPair = true;
                        break;
                    }
                    if(stack.peek().equals("[") || stack.peek().equals("(")) {
                        isValid = false;
                        break;
                    }
                    partValue += Integer.parseInt(stack.pop());
                }
                if(!reachedPair) {
                    isValid = false;
                    break;
                }
                if(!isValid) {
                    break;
                }
                if(!stack.isEmpty()) {
                    stack.pop();
                }
                if(partValue == 0) {
                    if(paren.equals("]")) {
                        stack.push(Integer.toString(LARGE_PARENTHESES));
                    } else {
                        stack.push(Integer.toString(SMALL_PARENTHESES));
                    }
                } else {
                    if(paren.equals("]")) {
                        stack.push(Integer.toString(partValue * LARGE_PARENTHESES));
                    } else {
                        stack.push(Integer.toString(partValue * SMALL_PARENTHESES));
                    }
                }
            }
        }

        while(!stack.isEmpty()) {
            if(stack.peek().equals("[") || stack.peek().equals("(")) {
                isValid = false;
                break;
            }
            totalValue += Integer.parseInt(stack.pop());
        }
        System.out.println((isValid) ? totalValue : 0);

        bf.close();
        System.exit(0);
    }

    // 해당 닫는 괄호에 매칭되는 여는 괄호를 반환함
    static String getPair(String closeParen) {
        if(closeParen.equals("]")) {
            return "[";
        } else {
            return "(";
        }
    }
}