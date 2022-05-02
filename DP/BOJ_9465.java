// BOJ - 9465
// Problem Sheet - https://www.acmicpc.net/problem/9465

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int t = key.nextInt(); // the number of test cases
		int[] result = new int[t]; // store the result value

		for(int i=0 ; i<t ; i++) {
			int n = key.nextInt();
			int[][] tc = new int[2][n+1]; // store the test case
			int[][] dp = new int[2][n+1]; // for dynamic programming
			for(int j=0 ; j<2 ; j++)
				for(int k=1 ; k<n+1 ; k++)
					tc[j][k] = key.nextInt();

			// find best solutions
			for(int j=1 ; j<n+1 ; j++) {
				if(j == 1) {
					dp[0][j] = tc[0][j];
					dp[1][j] = tc[1][j];
				}
				else {
					dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + tc[0][j];
					dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + tc[1][j];
				}
			}
			result[i] = Math.max(dp[0][n], dp[1][n]);
		}

		// print out the result
		for(int value : result)
			System.out.println(value);

		key.close();
		System.exit(0);
	}
}
