// BOJ - 15988
// Problem Sheet - https://www.acmicpc.net/problem/15988

import java.io.*;

public class Main {

    private static final int DIVIDER = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] dp = new long[1_000_001];
        dp[1] = 1L;
        dp[2] = 2L;
        dp[3] = 4L;
        for (int i=4 ; i<=1_000_000 ; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % DIVIDER;
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
