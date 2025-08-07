// BOJ - 22187
// Problem Sheet - https://www.acmicpc.net/problem/22187

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();
        boolean isReverse = false;
        for (int i=0 ; i<s.length() ; i++) {
            if (s.charAt(i) == '(') {
                isReverse = true;
            } else if (s.charAt(i) == ')') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                isReverse = false;
            } else {
                if (isReverse) stack.push(s.charAt(i));
                else sb.append(s.charAt(i));
            }
        }
        System.out.println(sb);
        br.close();
    }
}