// BOJ - 1463
// Problem Sheet - https://www.acmicpc.net/problem/1463

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int n = key.nextInt(); // the target number
		int[] dp = new int[n+1]; // for dynamic programming

		for(int i=0 ; i<n+1 ; i++) {
			// set default value
			if(i == 0 || i == 1) {
				dp[i] = 0;
				continue;
			}

			dp[i] = dp[i-1] + 1; // in case of -1
			if(i%3 == 0) // in case of divide 3
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
			if(i%2 == 0) // in case of divide 2
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
		}

		System.out.println(dp[n]);

		key.close();
		System.exit(0);
	}
}
