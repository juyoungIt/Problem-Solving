// BOJ - 26778
// Problem Sheet - https://www.acmicpc.net/problem/26778

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int answer = 0;
        Deque<Character> deque = new ArrayDeque<>(s.length());
        for (int i=0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            if (!deque.isEmpty() && deque.peekLast() == c) {
                answer++;
            } else {
                deque.add(c);
            }
        }
        System.out.println(answer);
        br.close();
    }
}