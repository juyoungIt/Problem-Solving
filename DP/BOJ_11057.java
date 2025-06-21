// BOJ - 11057
// Problem Sheet - https://www.acmicpc.net/problem/11057

import java.io.*;

public class Main {

    private static int n;
    private static int[][] dp;
    private static final int DIVIDER = 10_007;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][10];
        br.close();
    }

    private static int solve() {
        for (int i=0 ; i<=n ; i++) {
            for (int j=0 ; j<10 ; j++) {
                if(i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % DIVIDER;
            }
        }
        return dp[n][9] % DIVIDER;
    }

}
