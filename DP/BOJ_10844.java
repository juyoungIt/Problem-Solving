// BOJ - 10844
// Problem Sheet - https://www.acmicpc.net/problem/10844

import java.io.*;

public class Main {

	private static int N;
	private static int[][] dp;
	private static final int DIVIDER = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][10];
		br.close();
	}

	private static int solve() {
		// 1. 길이가 1인 경우 기본값을 채움
		for (int i=1 ; i<10 ; i++) {
			dp[1][i] = 1;
		}
		// 2. 길이가 2 이상인 경우에 대한 계단 수를 채움
		for (int i=2 ; i<=N ; i++) {
			for (int j=0 ; j<10 ; j++) {
				if (j == 0) dp[i][j] = dp[i - 1][j + 1] % DIVIDER;
				else if (j == 9) dp[i][j] = dp[i - 1][j - 1] % DIVIDER;
				else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % DIVIDER;
			}
		}
		// 3. 최종 합을 산출
		int sum = 0;
		for (int i=0 ; i<10 ; i++) {
			sum = (sum + dp[N][i]) % DIVIDER;
		}
		return sum;
	}

}
