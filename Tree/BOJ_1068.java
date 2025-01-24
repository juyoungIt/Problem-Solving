// BOJ - 1068
// Problem Sheet - https://www.acmicpc.net/problem/1068

import java.util.*;
import java.io.*;

public class Main {

    private static int N, X;
    private static int[] parents;
    private static List<Integer>[] al;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        al = new LinkedList[N];
        parents = new int[N];
        for (int i=0 ; i<N ; i++) {
            al[i] = new LinkedList<>();
        }

        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<N ; i++) {
            parents[i] = Integer.parseInt(row[i]);
            if (parents[i] < 0) continue;
            al[parents[i]].add(i);
        }

        X = Integer.parseInt(br.readLine());
        br.close();
    }

    private static int solve() {
        if (parents[X] >= 0) {
            al[parents[X]].remove((Integer) X);
        }
        deleteNode(X);
        return getLeafNodeCount();
    }

    private static void deleteNode(int node) {
        for (int child : al[node]) {
            deleteNode(child);
        }
        al[node] = null;
    }

    private static int getLeafNodeCount() {
        int leafNodeCount = 0;
        for (int i=0 ; i<N ; i++) {
            if (al[i] != null && al[i].isEmpty()) {
                leafNodeCount++;
            }
        }
        return leafNodeCount;
    }
}