// BOJ - 1309
// Problem Sheet - https://www.acmicpc.net/problem/1309

import java.io.*;

public class Main {

	private static int N;
	private static int[][] dp;
	private static final int DIVIDER = 9_901;
	private static final int NONE = 0, LEFT = 1, RIGHT = 2;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][3];
		br.close();
	}

	private static int solve() {
		dp[1][NONE] = 1;
		dp[1][LEFT] = 1;
		dp[1][RIGHT] = 1;
		for (int i=2 ; i<=N ; i++) {
			dp[i][NONE] = (dp[i - 1][NONE] + dp[i - 1][LEFT] + dp[i - 1][RIGHT]) % DIVIDER;
			dp[i][LEFT] = (dp[i - 1][RIGHT] + dp[i - 1][NONE]) % DIVIDER;
			dp[i][RIGHT] = (dp[i - 1][LEFT] + dp[i - 1][NONE]) % DIVIDER;
		}
		return (dp[N][NONE] + dp[N][LEFT] + dp[N][RIGHT]) % DIVIDER;
	}
}