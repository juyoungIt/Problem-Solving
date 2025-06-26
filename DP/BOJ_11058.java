// BOJ - 11058
// Problem Sheet - https://www.acmicpc.net/problem/11058

import java.io.*;

public class Main {

    private static int n;
    private static long[] dp;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1];
        br.close();
    }

    private static long solve() {
        for (int i=1 ; i<=n ; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j=3 ; j<i ; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * (j - 1));
            }
        }
        return dp[n];
    }

}