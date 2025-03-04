// BOJ - 1240
// Problem Sheet - https://www.acmicpc.net/problem/1240

import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        private final int index;
        private final int dist;

        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        public int getIndex() { return this.index; }
        public int getDist() { return this.dist; }
    }

    private static int N, M;
    private static List<Node>[] al;
    private static int[][] queries;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        N = Integer.parseInt(row[0]);
        M = Integer.parseInt(row[1]);
        al = new ArrayList[N + 1];
        for (int i=1 ; i<=N ; i++) {
            al[i] = new ArrayList<>();
        }
        for (int i=0 ; i<N-1 ; i++) {
            row = br.readLine().split(" ");
            int n1 = Integer.parseInt(row[0]);
            int n2 = Integer.parseInt(row[1]);
            int dist = Integer.parseInt(row[2]);
            al[n1].add(new Node(n2, dist));
            al[n2].add(new Node(n1, dist));
        }
        queries = new int[M][2];
        for (int i=0 ; i<M ; i++) {
            row = br.readLine().split(" ");
            queries[i][0] = Integer.parseInt(row[0]);
            queries[i][1] = Integer.parseInt(row[1]);
        }
        br.close();
    }

    private static void solve() {
        for (int[] query : queries) {
            visited = new boolean[N + 1];
            dfs(query[0], query[1], 0);
        }
    }

    private static void dfs(int sn, int en, int dist) {
        if (sn == en) {
            System.out.println(dist);
            return;
        }
        visited[sn] = true;
        for (Node node : al[sn]) {
            if (visited[node.getIndex()]) continue;
            dfs(node.getIndex(), en, dist + node.getDist());
        }
    }

}