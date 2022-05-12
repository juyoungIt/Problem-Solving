// BOJ - 9095
// Problem Sheet - https://www.acmicpc.net/problem/9095

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int[] dp = new int[11];
		int t = key.nextInt(); // the number of test cases
		int[] results = new int[t]; // store the result

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i=0 ; i<t ; i++) {
			int tmp = key.nextInt();
			if(dp[tmp] > 0) {
				results[i] = dp[tmp];
				continue;
			}
			for(int j=4 ; j<=tmp ; j++)
				dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
			results[i] = dp[tmp];
		}

		for(int result : results)
			System.out.println(result);

		key.close();
		System.exit(0);
	}
}
