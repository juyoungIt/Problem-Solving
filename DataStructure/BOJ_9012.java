// BOJ - 9012
// Problem Sheet - https://www.acmicpc.net/problem/9012

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>(); // 데이터 처리에 사용할 stack

        int t = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수
        boolean[] answers = new boolean[t]; // 각 테스트 케이스의 정답을 저장

        for(int i=0 ; i<t ; i++) {
            boolean finished = false; // 판별이 끝났는 지에 대한 여부
            String input = bf.readLine();
            for(int j=0 ; j<input.length() ; j++) {
                if(input.charAt(j) == '(')
                    stack.push('(');
                else if(input.charAt(j) == ')') {
                    if(!stack.isEmpty())
                        stack.pop();
                    else {
                        answers[i] = false;
                        finished = true;
                        break;
                    }
                }
            }
            if(!finished) {
                if(!stack.isEmpty()) {
                    answers[i] = false;
                    stack.clear();
                }
                else
                    answers[i] = true;
            }
        }

        for(boolean answer : answers)
            System.out.println((answer) ? "YES" : "NO");

        bf.close();
        System.exit(0);
    }
}