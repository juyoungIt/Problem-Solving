// BOJ - 2294
// Problem Sheet - https://www.acmicpc.net/problem/2294

import java.util.*;
import java.io.*;

public class Main {

    private static int n, k;
    private static int[] c;
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
        dp = new int[k + 1];
        Arrays.fill(dp, IMPOSSIBLE);
        c = new int[n];
        for (int i=0 ; i<n ; i++) {
            c[i] = Integer.parseInt(br.readLine());
            if (c[i] <= k) dp[c[i]] = 1;
        }
        br.close();
    }

    private static int solve() {
        for (int i=0 ; i<=k ; i++) {
            if (dp[i] == IMPOSSIBLE) continue;
            for (int j=0 ; j<n ; j++) {
                if (i + c[j] > k) continue;
                dp[i + c[j]] = Math.min(dp[i + c[j]], dp[i] + 1);
            }
        }
        return dp[k] == IMPOSSIBLE ? -1 : dp[k];
    }
}
