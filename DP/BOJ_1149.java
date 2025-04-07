// BOJ - 1149
// Problem Sheet - https://www.acmicpc.net/problem/1149

import java.util.*;
import java.io.*;

public class Main {

	private static int n;
	private static int[][] p;
	private static int[][] dp;
	private static final int RED = 0, GREEN = 1, BLUE = 2;
	private static final int IMPOSSIBLE = 1_000_001;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());	
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		p = new int[n + 1][3];
		for (int i=1 ; i<=n ; i++) {
			String[] row = br.readLine().split(" ");
			for (int j=0 ; j<3 ; j++) {
				p[i][j] = Integer.parseInt(row[j]);
			}
		}
		dp = new int[n + 1][3];
		for (int i=0 ; i<=n ; i++) {
			Arrays.fill(dp[i], IMPOSSIBLE);
		}
		br.close();
	}

	private static int solve() {
		dp[0][RED] = dp[0][GREEN] = dp[0][BLUE] = 0;
		for (int i=1 ; i<=n ; i++) {
			dp[i][RED] = Math.min(dp[i][RED], p[i][RED] + Math.min(dp[i - 1][GREEN], dp[i - 1][BLUE]));
			dp[i][GREEN] = Math.min(dp[i][GREEN], p[i][GREEN] + Math.min(dp[i - 1][RED], dp[i - 1][BLUE]));
			dp[i][BLUE] = Math.min(dp[i][BLUE], p[i][BLUE] + Math.min(dp[i - 1][RED], dp[i - 1][GREEN]));
		}
		return Math.min(dp[n][RED], Math.min(dp[n][GREEN], dp[n][BLUE]));
	}

}
