// BOJ - 11058
// Problem Sheet - https://www.acmicpc.net/problem/11058

import java.io.*;

public class Main {

    static int n;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1];
        br.close();
    }

    static long solve() {
        for (int i=1 ; i<=Math.min(6, n) ; i++) dp[i] = i;
        for (int i=6 ; i<=n ; i++) {
            dp[i] = Math.max(dp[i - 3] * 2, Math.max(dp[i - 4] * 3, dp[i - 5] * 4));
        }
        return dp[n];
    }

}