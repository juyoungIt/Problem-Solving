// BOJ - 11365
// Problem Sheet - https://www.acmicpc.net/problem/11365

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        Stack<Character> stack = new Stack<>();
        while(true) {
            input = bf.readLine();
            if(input.equals("END")) {
                break;
            }
            for(char letter : input.toCharArray()) {
                stack.add(letter);
            }
            while(!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb.append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}