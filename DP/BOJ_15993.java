// BOJ - 15993
// Problem Sheet - https://www.acmicpc.net/problem/15993

import java.io.*;

public class Main {

    private static final int SIZE = 100_000;
    private static final int DIVIDER = 1_000_000_009;
    private static final int EVEN = 0, ODD = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[SIZE + 1][2];
        dp[1][ODD] = dp[2][EVEN] = dp[2][ODD] = 1;
        dp[3][EVEN] = dp[3][ODD] = 2;
        for (int i=4 ; i<=SIZE ; i++) {
            dp[i][EVEN] = ((dp[i - 1][ODD] + dp[i - 2][ODD]) % DIVIDER + dp[i - 3][ODD]) % DIVIDER;
            dp[i][ODD] = ((dp[i - 1][EVEN] + dp[i - 2][EVEN]) % DIVIDER + dp[i - 3][EVEN]) % DIVIDER;
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(String.format("%d %d\n", dp[n][ODD], dp[n][EVEN]));
        }

        System.out.println(sb);
        br.close();
    }
}
