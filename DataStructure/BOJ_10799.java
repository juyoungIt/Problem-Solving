// BOJ - 10799
// Problem Sheet - https://www.acmicpc.net/problem/10799

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> stack = new ArrayDeque<>();

        int totalCount = 0;
        char[] brackets = br.readLine().toCharArray();
        char prev = brackets[0];
        stack.push(brackets[0]);
        for (int i=1 ; i<brackets.length ; i++) {
            if (brackets[i] == '(') {
                stack.push(brackets[i]);
            } else {
                stack.pop();
                if (prev == '(') {
                    totalCount += stack.size();
                } else {
                    totalCount ++;
                }
            }
            prev = brackets[i];
        }

        System.out.println(totalCount);
        br.close();
    }
}