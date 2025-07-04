// BOJ - 7579
// Problem Sheet - https://www.acmicpc.net/problem/7579

import java.io.*;

public class Main {

    private static int n, m;
    private static int[][] apps;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        n = Integer.parseInt(row[0]);
        m = Integer.parseInt(row[1]);
        apps = new int[n][2];
        row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            apps[i][0] = Integer.parseInt(row[i]);
        }
        row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            apps[i][1] = Integer.parseInt(row[i]);
        }
        dp = new int[10_001];
        br.close();
    }

    private static int solve() {
        for (int[] app : apps) {
            for (int i=10_000 ; i>=app[1] ; i--) {
                dp[i] = Math.max(dp[i], dp[i - app[1]] + app[0]);
            }
        }
        int cost = 0;
        while (dp[cost] < m) cost++;
        return cost;
    }

}
