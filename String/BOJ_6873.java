// BOJ - 6873
// Problem Sheet - https://www.acmicpc.net/problem/6873

import java.util.*;
import java.io.*;

public class Main {

    private static final String FORMAT_A = "Turn %s onto %s street.";
    private static final String FORMAT_B = "Turn %s into your HOME.";
    private static final String SCHOOL = "SCHOOL";
    private static final String LEFT = "LEFT";
    private static final String RIGHT = "RIGHT";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<String> stack = new ArrayDeque<>();
        while (true) {
            String direction = br.readLine();
            if (direction == null) break;
            String street = br.readLine();
            stack.push(direction);
            if (!street.equals(SCHOOL)) stack.push(street);
        }

        while (!stack.isEmpty()) {
            String direction = stack.pop();
            String newDirection = direction.charAt(0) == 'L' ? RIGHT : LEFT;
            if (stack.isEmpty()) {
                sb.append(String.format(FORMAT_B, newDirection)).append("\n");
                break;
            }
            String street = stack.pop();
            sb.append(String.format(FORMAT_A, newDirection, street)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}