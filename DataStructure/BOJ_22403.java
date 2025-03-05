// BOJ - 22403
// Problem Sheet - https://www.acmicpc.net/problem/22403

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<String> stack = new ArrayDeque<>();
        boolean isValid = true;
        while (N-- > 0) {
            String S = br.readLine();
            if (S.equals("A")) {
                stack.push(S);
            } else {
                if (stack.isEmpty()) {
                    isValid = false;
                    break;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) isValid = false;
        System.out.println(isValid ? "YES" : "NO");
        br.close();
    }
}