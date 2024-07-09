// BOJ - 5966
// Problem Sheet - https://www.acmicpc.net/problem/5966

import java.util.*;
import java.io.*;

public class Main {

    private static final String valid = "legal";
    private static final String invalid = "illegal";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Stack<Character> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            char[] cows = st.nextToken().toCharArray();
            boolean isValid = true;
            for (char cow : cows) {
                if (cow == '>') {
                    stack.push(cow);
                } else {
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (!isValid || !stack.isEmpty()) {
                sb.append(invalid).append("\n");
                stack.clear();
            } else {
                sb.append(valid).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}