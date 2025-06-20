// BOJ - 11055
// Problem Sheet - https://www.acmicpc.net/problem/11055

import java.io.*;

public class Main {

    private static int n;
    private static int[] a;
    private static int[] dp;
    private static int maxElement = 0;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            a[i] = Integer.parseInt(row[i]);
            maxElement = Math.max(maxElement, a[i]);
        }
        dp = new int[n];
        br.close();
    }

    private static int solve() {
        int maxSum = maxElement;
        for (int i=0 ; i<n ; i++) {
            dp[i] = a[i];
            for (int j=0 ; j<i ; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + a[i]);
                    maxSum = Math.max(maxSum, dp[i]);
                }
            }
        }
        return maxSum;
    }

}
