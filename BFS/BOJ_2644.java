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
        System.out.println(bfs());
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

    private static int bfs() {
        int dist = -1;
        Queue<Vertex> queue = new ArrayDeque<>();
        queue.add(new Vertex(u, 1));
        visited[u] = true;
        while (!queue.isEmpty()) {
            for (int g : graph[queue.peek().getValue()]) {
                if (g == v) return queue.peek().getDepth();
                if (visited[g]) continue;
                queue.add(new Vertex(g, queue.peek().getDepth() + 1));
                visited[g] = true;
            }
            queue.poll();
        }
        return dist;
    }
}