// BOJ - 1010
// Problem Sheet - https://www.acmicpc.net/problem/1010

import java.util.*;
import java.io.*;

public class Main {

    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        dp = new long[30][30];
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(comb(m, n)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static long comb(int n, int r) {
        if (n == r || r == 0) return dp[n][r] = 1;
        else if (dp[n][r] > 0) return dp[n][r];
        else return dp[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
    }
}
