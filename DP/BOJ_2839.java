// BOJ - 2839
// Problem Sheet - https://www.acmicpc.net/problem/2839

import java.util.*;
import java.io.*;

public class Main {
	
    private static int N;
    private static int[] dp;
    private static final int NOT_EXIST = 5_000;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        Arrays.fill(dp, NOT_EXIST);
        dp[3] = 1;
        if (N >= 5) dp[5] = 1; 
        br.close();
    }

    private static int solve() {
        for (int i=3 ; i<=N ; i++) {
            if (dp[i] == 0) continue;
            if (i + 3 <= N) dp[i + 3] = Math.min(dp[i + 3], dp[i] + 1);
            if (i + 5 <= N) dp[i + 5] = Math.min(dp[i + 5], dp[i] + 1);
        }
        return dp[N] == NOT_EXIST ? -1 : dp[N];
    }

}
