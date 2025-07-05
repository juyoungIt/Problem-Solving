// BOJ - 1932
// Problem Sheet - https://www.acmicpc.net/problem/1932

import java.io.*;

public class Main {

    private static int n;
    private static int[][] tri, dp;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tri = new int[n + 1][n + 1];
        for (int i=1 ; i<=n ; i++) {
            String[] row = br.readLine().split(" ");
            for (int j=1 ; j<=row.length ; j++) {
                tri[i][j] = Integer.parseInt(row[j - 1]);
            }
        }
        dp = new int[n + 1][n + 1];
        br.close();
    }

    private static int solve() {
        int max = 0;
        for (int i=1 ; i<=n ; i++) {
            for (int j=1 ; j<=i ; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + tri[i][j];
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

}
