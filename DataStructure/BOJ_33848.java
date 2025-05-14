// BOJ - 33848
// Problem Sheet - https://www.acmicpc.net/problem/33848

import java.util.*;
import java.io.*;

public class Main {

    private static int q;
    private static String[] queries;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        q = Integer.parseInt(br.readLine());
        queries = new String[q];
        for (int i=0 ; i<q ; i++) {
            queries[i] = br.readLine();
        }
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<String> backupStack = new ArrayDeque<>();
        Deque<Integer> popStack = new ArrayDeque<>();
        for (int i=0 ; i<q ; i++) {
            String[] token = queries[i].split(" ");
            int command = Integer.parseInt(token[0]);
            switch (command) {
                case 1:
                    stack.push(Integer.parseInt(token[1]));
                    backupStack.push(queries[i]);
                    break;
                case 2:
                    popStack.push(stack.pop());
                    backupStack.push(queries[i]);
                    break;
                case 3:
                    int back = Integer.parseInt(token[1]);
                    while (back > 0) {
                        String[] query = backupStack.pop().split(" ");
                        int cmd = Integer.parseInt(query[0]);
                        if (cmd != 1 && cmd != 2) continue;
                        if (cmd == 1) stack.pop();
                        else stack.push(popStack.pop());
                        back--;
                    }
                    break;
                case 4:
                    sb.append(stack.size()).append("\n");
                    break;
                case 5:
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                    break;
                default:
                    throw new IllegalArgumentException("invalid command!...");
            }
        }
        return sb.toString();
    }

}