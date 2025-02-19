// BOJ - 1405
// Problem Sheet - https://www.acmicpc.net/problem/1405

import java.io.*;

public class Main {

    private static int N;
    private static final double[] P = new double[4];
    private static boolean[][] visited;
    private static double answer = 0.0;
    private static final int[] xi = { 1, -1, 0, 0 };
    private static final int[] yi = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        input();
        visited[15][15] = true;
        solve(15, 15, 0, 1);
        System.out.printf("%.10f", answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<row.length ; i++) {
            if (i == 0) N = Integer.parseInt(row[i]);
            else P[i - 1] = Integer.parseInt(row[i]) * 0.01;
        }
        visited = new boolean[30][30];
        br.close();
    }

    private static void solve(int x, int y, int m, double p) {
        // 1. Base Case
        if (m == N) {
            answer += p;
            return;
        }
        // 2. Recursive Case
        for (int i=0 ; i<4 ; i++) {
            int nx = x + xi[i];
            int ny = y + yi[i];
            double np = p * P[i];
            if (isValid(nx, ny)) {
                if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    solve(nx, ny, m + 1, np);
                    visited[ny][nx] = false;
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x > 0 &&  y > 0 && x < 30 && y < 30;
    }
}