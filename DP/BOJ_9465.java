// BOJ - 9465
// Problem Sheet - https://www.acmicpc.net/problem/9465

import java.io.*;

public class Main {

    private static final int TOP = 0, BOTTOM = 1, NONE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n + 1];
            String[] row = br.readLine().split(" ");
            for (int i=1 ; i<=n ; i++) {
                stickers[0][i] = Integer.parseInt(row[i - 1]);
            }
            row = br.readLine().split(" ");
            for (int i=1 ; i<=n ; i++) {
                stickers[1][i] = Integer.parseInt(row[i - 1]);
            }
            int[][] dp = new int[3][n + 1];
            dp[NONE][1] = 0;
            dp[TOP][1] = stickers[TOP][1];
            dp[BOTTOM][1] = stickers[BOTTOM][1];
            for (int i=2 ; i<=n ; i++) {
                dp[TOP][i] = Math.max(dp[NONE][i - 1], dp[BOTTOM][i - 1]) + stickers[TOP][i];
                dp[BOTTOM][i] = Math.max(dp[NONE][i - 1], dp[TOP][i - 1]) + stickers[BOTTOM][i];
                dp[NONE][i] = Math.max(dp[NONE][i - 1], Math.max(dp[TOP][i - 1], dp[BOTTOM][i - 1]));
            }
            sb.append(Math.max(dp[NONE][n], Math.max(dp[TOP][n], dp[BOTTOM][n]))).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
