// BOJ - 15992
// Problem Sheet - https://www.acmicpc.net/problem/15992

import java.io.*;

public class Main {

    static final int RANGE = 1_000;
    static final int DIVIDER = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[][] dp = new long[RANGE + 1][RANGE + 1];
        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][3] = 1;
        dp[3][2] = 2;
        for (int i=4 ; i<=RANGE ; i++) {
            for (int j=1 ; j<=i ; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 2][j - 1] + dp[i - 3][j - 1]) % DIVIDER;
            }
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] row = br.readLine().split(" ");
            int n = Integer.parseInt(row[0]);
            int m = Integer.parseInt(row[1]);
            sb.append(dp[n][m]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}