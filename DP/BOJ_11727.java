// BOJ - 11727
// Problem Sheet - https://www.acmicpc.net/problem/11727

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 목표하는 수
        long[] dp = new long[n+1]; // dp를 위해 사용하는 cache

        // 기존에 정의된 기본값을 주입함
        dp[1] = 1;
        if(n >= 2) dp[2] = 3;
        System.out.println(getCount(dp, n));

        bf.close();
        System.exit(0);
    }

    public static long getCount(long[] dp, int n) {
        if(n == 1) return dp[1];
        else if(n == 2) return dp[2];
        else {
            if(dp[n] != 0) return dp[n]%10007;
            else return dp[n] = (getCount(dp,n-1) + getCount(dp,n-2) * 2)%10007;
        }
    }
}