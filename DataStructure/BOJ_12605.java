// BOJ - 12605
// Problem Sheet - https://www.acmicpc.net/problem/12605

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfCases = Integer.parseInt(bf.readLine());
        Stack<String> stack = new Stack<>();
        for(int i=1 ; i<=numberOfCases ; i++) {
            String[] tokens = bf.readLine().split(" ");
            stack.addAll(Arrays.asList(tokens));
            sb.append("Case #").append(i).append(": ");
            while(!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}