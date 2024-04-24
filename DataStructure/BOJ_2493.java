// BOJ - 2493
// Problem Sheet - https://www.acmicpc.net/problem/2493

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] towers = new int[n + 1];
        int[] received = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1 ; i<=n ; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i=n ; i>=1 ; i--) {
            if (!stack.isEmpty() && towers[stack.peek()] < towers[i]) {
                while (!stack.isEmpty() && towers[stack.peek()] < towers[i]) {
                    received[stack.peek()] = i;
                    stack.pop();
                }
            }
            stack.push(i);
        }

        for (int i=1 ; i<=n ; i++) {
            sb.append(received[i]).append(" ");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}