// BOJ - 1890
// Problem Sheet - https://www.acmicpc.net/problem/1890

import java.io.*;

public class Main {

    private static int n;
    private static int[][] board;
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i=0 ; i<n ; i++) {
            String[] row = br.readLine().split(" ");
            for (int j=0 ; j<n ; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }
        dp = new long[n][n];
        br.close();
    }

    private static long solve() {
        dp[0][0] = 1L;
        for (int i=0 ; i<n ; i++) {
            for (int j=0 ; j<n ; j++) {
                if (board[i][j] == 0) continue;
                int jump = board[i][j];
                if (i + jump < n) dp[i + jump][j] += dp[i][j];
                if (j + jump < n) dp[i][j + jump] += dp[i][j];
            }
        }
        return dp[n - 1][n - 1];
    }

}
