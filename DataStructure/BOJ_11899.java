// BOJ - 11899
// Problem Sheet - https://www.acmicpc.net/problem/11899

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> parenthesis = new Stack<>();
        int invalidCount = 0;

        char[] invalidSequence = bf.readLine().toCharArray();
        for(char bracket : invalidSequence) {
            if(bracket == '(') {
                parenthesis.push(bracket);
            } else {
                if(!parenthesis.isEmpty()) {
                    parenthesis.pop();
                } else {
                    invalidCount++;
                }
            }
        }
        invalidCount += parenthesis.size();
        System.out.println(invalidCount);

        bf.close();
        System.exit(0);
    }
}