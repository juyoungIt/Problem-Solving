// BOJ - 10971
// Problem Sheet - https://www.acmicpc.net/problem/10971

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int[][] matrix;
    private static boolean[] visited;
    private static int minCost = 10_000_001;

    public static void main(String[] args) throws IOException {
        input();
        for (int i=1 ; i<=N ; i++) {
            solve(i, -1, i, 0);
            Arrays.fill(visited, false);
        }
        System.out.println(minCost);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N + 1][N + 1];
        for (int i=1 ; i<=N ; i++) {
            String[] row = br.readLine().split(" ");
            for (int j=1 ; j<=N ; j++) {
                matrix[i][j] = Integer.parseInt(row[j - 1]);
            }
        }
        visited = new boolean[N + 1];
        br.close();
    }

    private static void solve(int src, int prev, int cur, int cost) {
        if (src == cur && prev > 0) {
            if (isFinish()) {
                minCost = Math.min(minCost, cost + matrix[prev][cur]);
            }
            return;
        }
        for (int i=1 ; i<=N ; i++) {
            if (!visited[i] && matrix[cur][i] > 0) {
                visited[i] = true;
                solve(src, cur, i, cost + (prev > 0 ? matrix[prev][cur] : 0));
                visited[i] = false;
            }
        }
    }

    private static boolean isFinish() {
        for (int i=1 ; i<=N ; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}