// BOJ - 15990
// Problem Sheet - https://www.acmicpc.net/problem/15990

import java.io.*;

public class Main {

    private static final int DIVIDER = 1_000_000_009;
    private static final int SIZE = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[SIZE + 1][4];
        dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
        for (int i=4 ; i<=SIZE ; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % DIVIDER;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % DIVIDER;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % DIVIDER;
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append((((dp[n][1] + dp[n][2]) % DIVIDER) + dp[n][3]) % DIVIDER).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
