// BOJ - 11055
// Problem Sheet - https://www.acmicpc.net/problem/11055

import java.io.*;

public class Main {

    static int n;
    static int[] a, dp;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            a[i] = Integer.parseInt(row[i]);
        }
        dp = new int[n];
        br.close();
    }

    static int solve() {
        int maxElementSum = 0;
        for (int i=0 ; i<n ; i++) {
            dp[i] = a[i];
            for (int j=0 ; j<i ; j++) {
                if (a[i] <= a[j]) continue;
                dp[i] = Math.max(dp[i], dp[j] + a[i]);
            }
            maxElementSum = Math.max(maxElementSum, dp[i]);
        }
        return maxElementSum;
    }

}