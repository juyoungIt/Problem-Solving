// BOJ - 2854
// Problem Sheet - https://www.acmicpc.net/problem/2854

import java.io.*;

public class Main {

    private static int n;
    private static long[] es, ed;
    private static long[][] dp;
    private static final int STATIC = 0, DYNAMIC_1 = 1, DYNAMIC_2 = 2;
    private static final int DIVIDER = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        es = new long[n + 1];
        ed = new long[n + 1];
        String[] row = br.readLine().split(" ");
        for (int i=1 ; i<=n ; i++) {
            es[i] = Integer.parseInt(row[i - 1]);
        }
        row = br.readLine().split(" ");
        for (int i=1 ; i<n ; i++) {
            ed[i] = Integer.parseInt(row[i - 1]);
        }
        dp = new long[3][n + 1];
        br.close();
    }

    private static long solve() {
        dp[STATIC][0] = 1;
        dp[DYNAMIC_1][0] = 0;
        dp[DYNAMIC_2][0] = 0;
        dp[STATIC][1] = es[1];
        dp[DYNAMIC_1][1] = ed[1];
        dp[DYNAMIC_2][1] = 0;

        for (int i=2 ; i<=n ; i++) {
            dp[STATIC][i] = ((dp[STATIC][i - 1] + dp[DYNAMIC_1][i - 1] + dp[DYNAMIC_2][i - 1]) * es[i]) % DIVIDER;
            dp[DYNAMIC_1][i] = ((dp[STATIC][i - 1] + dp[DYNAMIC_1][i - 1] + dp[DYNAMIC_2][i - 1]) * ed[i]) % DIVIDER;
            dp[DYNAMIC_2][i] = ((dp[STATIC][i - 1] + dp[DYNAMIC_2][i - 1]) * ed[i - 1]) % DIVIDER
                + ((ed[i - 1] * (ed[i - 1] - 1)) % DIVIDER)
                * (dp[STATIC][i - 2] + dp[DYNAMIC_1][i - 2] + dp[DYNAMIC_2][i - 2]) % DIVIDER;
        }

        return (dp[STATIC][n] + dp[DYNAMIC_1][n] + dp[DYNAMIC_2][n]) % DIVIDER;
    }

}
