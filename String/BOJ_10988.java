// BOJ - 10988
// Problem Sheet - https://www.acmicpc.net/problem/10988

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String word = bf.readLine();
        for(char letter : word.toCharArray()) {
            stack.push(letter);
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        if(word.contentEquals(sb)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        bf.close();
        System.exit(0);
    }
}