// BOJ - 1912
// Problem Sheet - https://www.acmicpc.net/problem/1912

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 정수 n
        int[] seq = new int[n]; // 입력된 수열
        int[] dp = new int[n];
        int answer = Integer.MIN_VALUE; // 가장 큰 연속합의 크기

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++)
            seq[i] = Integer.parseInt(st.nextToken());

        dp[0] = seq[0];
        answer = dp[0];
        for(int i=1 ; i<n ; i++) {
            dp[i] = Math.max(seq[i], dp[i-1] + seq[i]);
            answer = Math.max(dp[i], answer);
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}