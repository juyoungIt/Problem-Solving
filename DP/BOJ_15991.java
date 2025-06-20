// BOJ - 15991
// Problem Sheet - https://www.acmicpc.net/problem/15991

import java.io.*;

public class Main {

    private static final int SIZE = 100_000;
    private static final int DIVIDER = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] dp = new int[SIZE + 1];
        dp[1] = 1;
        dp[2] = dp[3] = 2;
        dp[4] = dp[5] = 3;
        dp[6] = dp[7] = 6;
        for (int i=8 ; i<=SIZE ; i++) {
            dp[i] = (((dp[i - 6] + dp[i - 4]) % DIVIDER) + dp[i - 2]) % DIVIDER;
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
