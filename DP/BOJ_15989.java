// BOJ - 15989
// Problem Sheet - https://www.acmicpc.net/problem/15989

import java.io.*;

public class Main {

    static final int RANGE = 10_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] dp = new int[RANGE + 1];
        int[] elements = { 1, 2, 3 };
        dp[0] = 1;
        for (int element : elements) {
            for (int i=0 ; i+element<=RANGE ; i++) {
                dp[i + element] += dp[i];
            }
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}