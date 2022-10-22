// BOJ - 2579
// Problem Sheet - https://www.acmicpc.net/problem/2579

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine()); // 계단의 수
        int[] s = new int[n+1];  // 각 계단에서 얻을 수 있는 점수
        int[] dp = new int[n+1]; // 각 위치에서 얻을 수 있는 최대점수
        for(int i=1 ; i<=n ; i++)
            s[i] = Integer.parseInt(bf.readLine());

        dp[1] = s[1];
        if(n > 1) dp[2] = s[1]+s[2];

        System.out.println(getScore(dp, s, n));

        bf.close();
        System.exit(0);
    }

    static int getScore(int[] dp, int[] s, int i) {
        if(i == 0) return 0;
        else if(i == 1) return dp[1];
        else if(i == 2) return dp[2];
        else {
            if(dp[i] > 0) return dp[i];
            return dp[i] = Math.max(getScore(dp, s, i-2)+s[i], getScore(dp, s, i-3)+s[i-1]+s[i]);
        }
    }
}