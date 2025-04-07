// BOJ - 1932
// Problem Sheet - https://www.acmicpc.net/problem/1932

import java.util.*;
import java.io.*;

public class Main {

	private static int n;
	private static int[][] t, dp;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());	
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		t = new int[n + 1][n];
		for (int i=1 ; i<=n ; i++) {
			String[] row = br.readLine().split(" ");
			for (int j=0 ; j<row.length ; j++) {
				t[i][j] = Integer.parseInt(row[j]);
			}
		}
		dp = new int[n + 1][n];
		br.close();
	}

	private static int solve() {
		dp[1][0] = t[1][0];
		for (int i=0 ; i<n ; i++) {
			for (int j=0 ; j<i ; j++) {
				dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + t[i + 1][j]);
				dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + t[i + 1][j + 1]);
			}
		}
		Arrays.sort(dp[n]);
		return dp[n][n - 1];
	}
}
