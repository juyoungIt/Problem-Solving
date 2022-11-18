// BOJ - 9461
// Problem Sheet - https://www.acmicpc.net/problem/9461

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tcSize = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수
        long[] dp = new long[101];
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;

        for(int i=0 ; i<tcSize ; i++) {
            int number = Integer.parseInt(bf.readLine());
            System.out.println(getNumber(dp, number));
        }

        bf.close();
        System.exit(0);
    }

    static long getNumber(long[] dp, int index) {
        if(dp[index] != 0)
            return dp[index];
        else
            return dp[index] = getNumber(dp, index-1) + getNumber(dp, index-5);
    }
}