// BOJ - 15992
// Problem Sheet - https://www.acmicpc.net/problem/15992

import java.io.*;

public class Main {

    private static final int SIZE = 1_000;
    private static final int DIVIDER = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[SIZE + 1][SIZE + 1];
        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][3] = 1;
        dp[3][2] = 2;
        for (int i=4 ; i<=SIZE ; i++) {
            for (int j=1 ; j<=i ; j++) {
                if (j == 1) dp[i][j] = 0;
                else if (j == i) dp[i][j] = 1;
                else dp[i][j] = ((dp[i - 1][j - 1] + dp[i - 2][j - 1]) % DIVIDER + dp[i - 3][j - 1]) % DIVIDER;
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
