// BOJ - 3986
// Problem Sheet - https://www.acmicpc.net/problem/3986

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 단어의 수
        int answer = 0;

        for(int i=0 ; i<n ; i++) {
            String word = bf.readLine();
            if(isGoodWord(word)) answer++;
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    private static boolean isGoodWord(String word) {
        Stack<Character> stack = new Stack<>();
        char[] letters = word.toCharArray();

        for(char c : letters) {
            if(stack.isEmpty()) stack.add(c);
            else if(stack.peek() == c) stack.pop();
            else stack.add(c);
        }

        return stack.isEmpty();
    }
}