// BOJ - 15989
// Problem Sheet - https://www.acmicpc.net/problem/15989

import java.io.*;

public class Main {

    private static final int SIZE = 10_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[SIZE + 1][4];
        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
        for (int i=4 ; i<=SIZE ; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int sum = dp[n][1] + dp[n][2] + dp[n][3];
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
