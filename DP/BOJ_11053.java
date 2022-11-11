// BOJ - 11053
// Problem Sheet - https://www.acmicpc.net/problem/11053

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 수열의 크기
        int[] sequence = new int[n]; // 수열의 정보
        int[] dp = new int[n]; // 수열의 i번째 원소가 포함될 경우의 최대 증가수열의 길이
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++)
            sequence[i] = Integer.parseInt(st.nextToken());

        for(int i=0 ; i<n ; i++) {
            dp[i] = 1;
            for(int j=0 ; j<i ; j++)
                if(sequence[j] < sequence[i])
                    dp[i] = Math.max(dp[i], dp[j]+1);
        }

        Arrays.sort(dp);
        System.out.println(dp[n-1]);

        bf.close();
        System.exit(0);
    }
}