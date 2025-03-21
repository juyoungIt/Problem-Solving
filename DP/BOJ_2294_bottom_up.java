// BOJ - 2294
// Problem Sheet - https://www.acmicpc.net/problem/2294

import java.util.*;
import java.io.*;

public class Main {

    private static int n, k;
    private static int[] coin;
    private static int[] dp;

    private static final int NOT_EXIST = 10_001;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        n = Integer.parseInt(row[0]);
        k = Integer.parseInt(row[1]);
        coin = new int[n];
        for (int i=0 ; i<n ; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[k + 1];
        Arrays.fill(dp, NOT_EXIST);
        br.close();
    }

    private static int solve() {
        dp[0] = 0;
        for (int i=0 ; i<n ; i++) {
            for (int j=0 ; j + coin[i]<=k ; j++) {
                if (dp[j] == NOT_EXIST) continue;
                dp[j + coin[i]] = Math.min(dp[j + coin[i]], dp[j] + 1);
            }
        }
        return dp[k] == NOT_EXIST ? -1 : dp[k];
    }
}
