// BOJ - 15486
// Problem Sheet - https://www.acmicpc.net/problem/15486

import java.io.*;

public class Main {

    private static int n;
    private static int[][] c;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        c = new int[n + 2][2];
        for (int i=1 ; i<=n ; i++) {
            String[] row = br.readLine().split(" ");
            c[i][0] = Integer.parseInt(row[0]);
            c[i][1] = Integer.parseInt(row[1]);
        }
        dp = new int[n + 2];
        br.close();
    }

    private static int solve() {
        for (int i=1 ; i<=n+1 ; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i]);
            if (i + c[i][0] > n + 1) continue;
            dp[i + c[i][0]] = Math.max(dp[i + c[i][0]], dp[i] + c[i][1]);
        }
        return dp[n + 1];
    }

}