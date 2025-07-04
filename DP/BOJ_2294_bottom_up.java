// BOJ - 2294
// Problem Sheet - https://www.acmicpc.net/problem/2294

import java.util.*;
import java.io.*;

public class Main {

    private static int n, k;
    private static int[] coins;
    private static int[] dp;
    private static final int IMPOSSIBLE = 10_001;

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
        Arrays.fill(dp, IMPOSSIBLE);
        br.close();
    }

    private static int solve() {
        dp[0] = 0;
        for (int coin : coins) {
            for (int i=0 ; i+coin<=k ; i++) {
                if (dp[i] == IMPOSSIBLE) continue;
                dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
            }
        }
        return dp[k] == IMPOSSIBLE ? -1 : dp[k];
    }

}
