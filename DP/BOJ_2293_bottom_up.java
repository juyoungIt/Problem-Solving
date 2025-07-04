// BOJ - 2293
// Problem Sheet - https://www.acmicpc.net/problem/2293

import java.io.*;

public class Main {

    private static int n, k;
    private static int[] coins, dp;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        n = Integer.parseInt(row[0]);
        k = Integer.parseInt(row[1]);
        coins = new int[n];
        for (int i=0 ; i<n ; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[k + 1];
        br.close();
    }

    private static int solve() {
        dp[0] = 1;
        for (int coin : coins) {
            for (int i=0 ; i+coin<=k ; i++) {
                dp[i + coin] += dp[i];
            }
        }
        return dp[k];
    }

}
