// BOJ - 9019
// Problem Sheet - https://www.acmicpc.net/problem/9019

import java.util.*;
import java.io.*;

public class Main {

    static class Status {
        private final int value;
        private final String history;

        public Status(int value, String history) {
            this.value = value;
            this.history = history;
        }

        public int getValue() { return this.value; }
        public String getHistory() { return this.history; }
    }

    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] row = br.readLine().split(" ");
            int A = Integer.parseInt(row[0]);
            int B = Integer.parseInt(row[1]);
            visited = new boolean[10_000];
            sb.append(solve(A, B)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static String solve(int a, int b) {
        Queue<Status> queue = new ArrayDeque<>();
        String commands = "";
        queue.add(new Status(a, ""));
        visited[a] = true;
        while (!queue.isEmpty()) {
            Status cur = queue.poll();
            if (cur.getValue() == b) {
                commands = cur.getHistory();
                break;
            }
            for (int i=0 ; i<4 ; i++) {
                int next = getNextValue(cur.getValue(), i);
                if (visited[next]) continue;
                queue.add(new Status(next, cur.getHistory() + getCommand(i)));
                visited[next] = true;
            }
        }
        return commands;
    }

    private static int getNextValue(int n, int type) {
        if (type == 0) return (n * 2) % 10_000; // D
        else if (type == 1) return n == 0 ? 9_999 : n - 1; // S
        else if (type == 2) return n % (int) Math.pow(10, 3) * 10 + n / (int) Math.pow(10, 3); // L
        else return n / 10 + (n % 10) * (int) Math.pow(10, 3); // R
    }

    private static char getCommand(int type) {
        if (type == 0) return 'D';
        else if (type == 1) return 'S';
        else if (type == 2) return 'L';
        else return 'R';
    }
}