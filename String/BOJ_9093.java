// BOJ - 9093
// Problem Sheet - https://www.acmicpc.net/problem/9093

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfTestCases = Integer.parseInt(bf.readLine());
        Stack<Character> stack = new Stack<>();
        for(int i=0 ; i<numberOfTestCases ; i++) {
            String[] tokens = bf.readLine().split(" ");
            for(String token : tokens) {
                char[] letters = token.toCharArray();
                for(char letter : letters) {
                    stack.push(letter);
                }
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}