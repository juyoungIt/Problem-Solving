// BOJ - 15681
// Problem Sheet - https://www.acmicpc.net/problem/15681

import java.util.*;
import java.io.*;

public class Main {

    private static int N, R, Q;
    private static List<Integer>[] al;
    private static int[] queries;
    private static int[] counts;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        N = Integer.parseInt(row[0]);
        R = Integer.parseInt(row[1]);
        Q = Integer.parseInt(row[2]);
        al = new ArrayList[N + 1];
        for (int i=1 ; i<=N ; i++) {
            al[i] = new ArrayList<>();
        }

        for (int i=0 ; i<N-1 ; i++) {
            row = br.readLine().split(" ");
            int u = Integer.parseInt(row[0]);
            int v = Integer.parseInt(row[1]);
            al[u].add(v);
            al[v].add(u);
        }

        queries = new int[Q];
        for (int i=0 ; i<Q ; i++) {
            queries[i] = Integer.parseInt(br.readLine());
        }
        counts = new int[N + 1];
        visit = new boolean[N + 1];
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        getNodeCount(R);
        for (int query : queries) {
            sb.append(counts[query]).append("\n");
        }
        return sb.toString();
    }

    private static int getNodeCount(int rootNode) {
        if (counts[rootNode] > 0) {
            return counts[rootNode];
        }
        visit[rootNode] = true;
        int count = 1;
        for (int node : al[rootNode]) {
            if (!visit[node]) {
                count += getNodeCount(node);
            }
        }
        counts[rootNode] = count;
        return counts[rootNode];
    }
}