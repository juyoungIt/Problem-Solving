// BOJ - 4949
// Problem Sheet - https://www.acmicpc.net/problem/4949

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Boolean> answers = new LinkedList<>(); // 각 문제에 대한 정답 저장

        while(true) {
            String tmp = bf.readLine();
            if(tmp.equals(".")) break;
            answers.add(checkBalance(tmp));
        }

        for(boolean answer : answers)
            System.out.println(answer ? "yes" : "no");

        bf.close();
        System.exit(0);
    }

    static boolean checkBalance(String s) {
        Stack<Character> paren = new Stack<>(); // 괄호를 저장하는 stack
        boolean result = true;

        for(int i=0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[') paren.add(c);
            if(c == ')' || c == ']') {
                if(paren.isEmpty()) {
                    result = false;
                    break;
                }
                if(c == ')') {
                    if(paren.peek() == '(') paren.pop();
                    else {
                        result = false;
                        break;
                    }
                }
                if(c == ']') {
                    if(paren.peek() == '[') paren.pop();
                    else {
                        result = false;
                        break;
                    }
                }
            }
        }
        if(paren.size() > 0) result = false;
        return result;
    }
}