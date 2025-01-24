// BOJ - 11725
// Problem Sheet - https://www.acmicpc.net/problem/11725

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static List<Integer>[] al;
    private static int[] parents;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        al = new ArrayList[N + 1];
        for (int i=1 ; i<=N ; i++) {
            al[i] = new ArrayList<>();
        }
        for (int i=0 ; i<N-1 ; i++) {
            String[] row = br.readLine().split(" ");
            int nodeA = Integer.parseInt(row[0]);
            int nodeB = Integer.parseInt(row[1]);
            al[nodeA].add(nodeB);
            al[nodeB].add(nodeA);
        }
        parents = new int[N + 1];
        visit = new boolean[N + 1];
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        find(1);
        for (int i=2 ; i<=N ; i++) {
            sb.append(parents[i]).append("\n");
        }
        return sb.toString();
    }

    private static void find(int parentNode) {
        visit[parentNode] = true;
        for (int node : al[parentNode]) {
            if (!visit[node]) {
                parents[node] = parentNode;
                find(node);
            }
        }
    }
}