// BOJ - 10159
// Problem Sheet - https://www.acmicpc.net/problem/10159

import java.util.*;
import java.io.*;

public class Main {

    private static int N, M;
    private static List<Integer>[] al;
    private static int[] visitedCounts;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        al = new ArrayList[N + 1];
        for (int i=1 ; i<=N ; i++) {
            al[i] = new ArrayList<>();
        }
        for (int i=0 ; i<M ; i++) {
            String[] row = br.readLine().split(" ");
            int o1 = Integer.parseInt(row[0]);
            int o2 = Integer.parseInt(row[1]);
            al[o1].add(o2);
        }
        visitedCounts = new int[N + 1];
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        for (int i=1 ; i<=N ; i++) {
            dfs(i);
        }
        for (int i=1 ; i<=N ; i++) {
            sb.append(N - visitedCounts[i]).append("\n");
        }
        return sb.toString();
    }

    private static void dfs(int sv) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        stack.push(sv);
        visited[sv] = true;
        visitedCounts[sv]++;
        while (!stack.isEmpty()) {
            boolean allConnected = true;
            for (int n : al[stack.peek()]) {
                if (visited[n]) continue;
                stack.push(n);
                visited[n] = true;
                visitedCounts[sv]++;
                visitedCounts[n]++;
                allConnected = false;
                break;
            }
            if (allConnected) stack.pop();
        }
    }
}