// BOJ - 11945
// Problem Sheet - https://www.acmicpc.net/problem/11945

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        Stack<Character> stack = new Stack<>();
        for(int i=0 ; i<height ; i++) {
            String input = bf.readLine();
            for(int j=0 ; j<width ; j++) {
                stack.push(input.charAt(j));
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