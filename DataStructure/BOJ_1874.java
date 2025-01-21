// BOJ - 1874
// Problem Sheet - https://www.acmicpc.net/problem/1874

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[] seq;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        seq = new int[n];
        for (int i=0 ; i<n ; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int curIndex = 0;
        for (int i=1 ; i<=n ; i++) {
            if (!stack.isEmpty() && stack.peek() == seq[curIndex]) {
                stack.pop();
                sb.append("-").append("\n");
                curIndex++;
                i--;
            } else {
                stack.push(i);
                sb.append("+").append("\n");
            }
        }

        while (!stack.empty()) {
            if (stack.pop() != seq[curIndex++]) {
                sb.setLength(0);
                sb.append("NO");
                break;
            }
            sb.append("-").append("\n");
        }

        return sb.toString();
    }
}