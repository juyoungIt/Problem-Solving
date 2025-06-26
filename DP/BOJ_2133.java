// BOJ - 2133
// Problem Sheet - https://www.acmicpc.net/problem/2133

import java.io.*;

public class Main {

    private static int n;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        br.close();
    }

    private static int solve() {
        dp[0] = 1;
        for (int i=2 ; i<=n ; i+=2) {
            dp[i] = dp[i - 2] * 3;
            for (int j=i-4 ; j>=0 ; j-=2) {
                dp[i] += dp[j] * 2;
            }
        }
        return dp[n];
    }

}