// BOJ - 1495
// Problem Sheet - https://www.acmicpc.net/problem/1495

import java.io.*;

public class Main {

    static int n, s, m;
    static int[] v;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        n = Integer.parseInt(row[0]);
        s = Integer.parseInt(row[1]);
        m = Integer.parseInt(row[2]);
        v = new int[n + 1];
        row = br.readLine().split(" ");
        for (int i=1 ; i<=n ; i++) {
            v[i] = Integer.parseInt(row[i - 1]);
        }
        dp = new boolean[n + 1][m + 1];
        br.close();
    }

    static int solve() {
        dp[0][s] = true;
        for (int i=1 ; i<=n ; i++) {
            for (int j=0 ; j<=m ; j++) {
                if (!dp[i - 1][j]) continue;
                if (j - v[i] >= 0) dp[i][j - v[i]] = true;
                if (j + v[i] <= m) dp[i][j + v[i]] = true;
            }
        }
        for (int i=m ; i>=0 ; i--) {
            if (dp[n][i]) return i;
        }
        return -1;
    }

}