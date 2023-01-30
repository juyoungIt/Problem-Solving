// BOJ - 16815
// Problem Sheet - https://www.acmicpc.net/problem/16815

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> openParen = new Stack<>(); // 여는 괄호를 저장하는 stack

        String inputStr = bf.readLine();
        for(int i=0 ; i<inputStr.length() ; i++) {
            char paren = inputStr.charAt(i);
            if(paren == '(') {
                openParen.add(paren);
            } else if(paren == ')') {
                openParen.pop();
            } else { // '*'를 만난 경우
                break;
            }
        }

        System.out.println(openParen.size());

        bf.close();
        System.exit(0);
    }
}