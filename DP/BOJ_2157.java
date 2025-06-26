// BOJ - 2157
// Problem Sheet - https://www.acmicpc.net/problem/2157

import java.util.*;
import java.io.*;

public class Main {

    private static int n, m, k;
    private static int[][] scores, dp;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        n = Integer.parseInt(row[0]);
        m = Integer.parseInt(row[1]);
        k = Integer.parseInt(row[2]);
        scores = new int[n + 1][n + 1];
        for (int i=0 ; i<k ; i++) {
            row = br.readLine().split(" ");
            int a = Integer.parseInt(row[0]);
            int b = Integer.parseInt(row[1]);
            int c = Integer.parseInt(row[2]);
            scores[a][b] = Math.max(scores[a][b], c);
        }
        dp = new int[m + 1][n + 1];
        for (int i=0 ; i<=m ; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        br.close();
    }

    private static int solve() {
        dp[1][1] = 0;
        for (int i=1 ; i<=m ; i++) {
            for (int j=1 ; j<=n ; j++) {
                for (int k=1 ; k<j ; k++) {
                    if (scores[k][j] == 0 || dp[i - 1][k] == Integer.MIN_VALUE) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + scores[k][j]);
                }
            }
        }
        int maxScore = 0;
        for (int i=1 ; i<=m ; i++) {
            maxScore = Math.max(maxScore, dp[i][n]);
        }
        return maxScore;
    }

}