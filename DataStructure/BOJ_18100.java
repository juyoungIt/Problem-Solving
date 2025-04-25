// BOJ - 18100
// Problem Sheet - https://www.acmicpc.net/problem/18100

import java.util.*;
import java.io.*;

public class Main {

    private static final String ADD = "Add";
    private static final String VOTE = "Vote";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        Deque<Character> stack = new ArrayDeque<>(k);
        boolean isValid = true;
        while (k-- > 0) {
            String[] row = br.readLine().split(" ");
            String type = row[0];
            char group = row[1].charAt(0);
            if (type.equals(ADD)) {
                stack.push(group);
            } else if (type.equals(VOTE)){
                if (stack.isEmpty() || stack.peek() != group) {
                    isValid = false;
                    break;
                }
                stack.pop();
            } else {
                throw new IllegalArgumentException("Invalid command...");
            }
        }

        System.out.println(!isValid || !stack.isEmpty() ? "No" : "Yes");
        br.close();
    }
}