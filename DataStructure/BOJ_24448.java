// BOJ - 24448
// Problem Sheet - https://www.acmicpc.net/problem/24448

import java.util.*;
import java.io.*;

public class Main {

    private static int Q;
    private static String[] command;
    private static Deque<String> stack;

    private static final String READ = "READ";

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Q = Integer.parseInt(br.readLine());
        command = new String[Q];
        for (int i=0 ; i<Q ; i++) {
            command[i] = br.readLine();
        }
        stack = new ArrayDeque<>();
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<Q ; i++) {
            if (command[i].equals(READ)) {
                sb.append(stack.pop()).append("\n");
            } else {
                stack.push(command[i]);
            }
        }
        return sb.toString();
    }
}
