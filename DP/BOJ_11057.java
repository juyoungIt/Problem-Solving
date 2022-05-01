// BOJ - 11057
// Problem Sheet - https://www.acmicpc.net/problem/11057

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int length = key.nextInt();
		int[][] dp = new int[length+1][10]; // for dynamic programming

		for(int i=0 ; i<length+1 ; i++) {
			for(int j=0 ; j<10 ; j++) {
				if(i == 0 || j == 0) dp[i][j] = 1;
				else dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 10007;
			}
		}

		System.out.println(dp[length][9]);

		key.close();
		System.exit(0);
	}
}
