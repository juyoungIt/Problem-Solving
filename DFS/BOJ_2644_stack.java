// BOJ - 2644
// Problem Sheet - https://www.acmicpc.net/problem/2644

import java.util.*;
import java.io.*;

public class Main {

    static class Vertex {
        private final int value;
        private final int depth;

        public Vertex(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }

        public int getValue() { return this.value; }
        public int getDepth() { return this.depth; }
    }

    private static int n, u, v;
    private static List<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        input();
        dfs(u);
        System.out.println(-1);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] row = br.readLine().split(" ");
        u = Integer.parseInt(row[0]);
        v = Integer.parseInt(row[1]);
        graph = new ArrayList[n + 1];
        for (int i=1 ; i<=n ; i++) {
            graph[i] = new ArrayList<>();
        }
        int m = Integer.parseInt(br.readLine());
        for (int i=0 ; i<m ; i++) {
            row = br.readLine().split(" ");
            int x = Integer.parseInt(row[0]);
            int y = Integer.parseInt(row[1]);
            graph[x].add(y);
            graph[y].add(x);
        }
        visited = new boolean[n + 1];
        br.close();
    }

    private static void dfs(int sv) {
        Deque<Vertex> stack = new ArrayDeque<>();
        stack.push(new Vertex(sv, 0));
        visited[sv] = true;
        while (!stack.isEmpty()) {
            boolean allConnected = true;
            for (int g : graph[stack.peek().getValue()]) {
                if (g == v) {
                    System.out.println(stack.peek().getDepth() + 1);
                    System.exit(0);
                }
                if (visited[g]) continue;
                stack.push(new Vertex(g, stack.peek().getDepth() + 1));
                visited[g] = true;
                allConnected = false;
                break;
            }
            if (allConnected) stack.pop();
        }
    }
}