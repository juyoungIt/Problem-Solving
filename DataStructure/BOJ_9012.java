// BOJ - 9012
// Problem Sheet - https://www.acmicpc.net/problem/9012

import java.util.*;
import java.io.*;

public class Main {

    enum Result {
        YES, NO
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            sb.append(isValid(br.readLine())
                        ? Result.YES
                        : Result.NO
                    ).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static boolean isValid(String candidate) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0 ; i<candidate.length() ; i++) {
            if (candidate.charAt(i) == '(') {
                stack.push(candidate.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}