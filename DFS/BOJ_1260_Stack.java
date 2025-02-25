// BOJ - 1260
// Problem Sheet - https://www.acmicpc.net/problem/1260

import java.util.*;
import java.io.*;

public class Main {

    private static int N, M, V;
    private static List<Integer>[] al;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        dfs(V);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        N = Integer.parseInt(row[0]);
        M = Integer.parseInt(row[1]);
        V = Integer.parseInt(row[2]);
        al = new ArrayList[N + 1];
        for (int i=1 ; i<=N ; i++) {
            al[i] = new ArrayList<>();
        }
        for (int i=0 ; i<M ; i++) {
            row = br.readLine().split(" ");
            int nodeA = Integer.parseInt(row[0]);
            int nodeB = Integer.parseInt(row[1]);
            al[nodeA].add(nodeB);
            al[nodeB].add(nodeA);
        }
        for (int i=1 ; i<=N ; i++) {
            Collections.sort(al[i]);
        }
        br.close();
    }

    private static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.add(startNode);
        visited[startNode] = true;
        sb.append(startNode).append(" ");
        while (!queue.isEmpty()) {
            for (int node : al[queue.poll()]) {
                if (visited[node]) continue;
                queue.add(node);
                visited[node] = true;
                sb.append(node).append(" ");
            }
        }
    }

    private static void dfs(int startNode) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        stack.push(startNode);
        visited[startNode] = true;
        sb.append(startNode).append(" ");
        while (!stack.isEmpty()) {
            boolean allConnected = true;
            for (int node : al[stack.peek()]) {
                if (visited[node]) continue;
                allConnected = false;
                stack.push(node);
                visited[node] = true;
                sb.append(node).append(" ");
                break;
            }
            if (allConnected) stack.pop();
        }
    }
}