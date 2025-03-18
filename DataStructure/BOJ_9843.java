// BOJ - 9843
// Problem Sheet - https://www.acmicpc.net/problem/9843

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static String[] commands;
    private static Integer register;
    private static Deque<Integer> stack;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        commands = new String[n];
        stack = new ArrayDeque<>();
        for (int i=0 ; i<n ; i++) {
            commands[i] = br.readLine();
        }
        br.close();
    }

    private static Integer solve() {
        int ni = 0; // 다음 명령어 위치를 저장
        while (ni < n) {
            String[] command = commands[ni].split(" ");
            switch (command[0]) {
                case "PUSH":
                    int x = Integer.parseInt(command[1]);
                    stack.push(x);
                    break;
                case "STORE":
                    if (stack.isEmpty()) throw new IllegalStateException("stack is empty!...");
                    register = stack.pop();
                    break;
                case "LOAD":
                    stack.push(register);
                    break;
                case "PLUS":
                    if (stack.size() < 2) throw new IllegalStateException("operands does not exist...");
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "TIMES":
                    if (stack.size() < 2) throw new IllegalStateException("operands does not exist...");
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "IFZERO":
                    if (stack.isEmpty()) throw new IllegalStateException("stack is empty!...");
                    int jump = Integer.parseInt(command[1]);
                    if (stack.pop() == 0) {
                        ni = jump;
                        continue;
                    }
                    break;
                case "DONE":
                    if (stack.isEmpty()) throw new IllegalStateException("stack is empty!...");
                    return stack.pop();
                default:
                    throw new IllegalArgumentException(String.format("invalid commands... %s", command[0]));
            }
            ni++;
        }
        return null;
    }
}
