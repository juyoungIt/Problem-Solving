// BOJ - 2156
// Problem Sheet - https://www.acmicpc.net/problem/2156

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int size = key.nextInt();     // the number of values
		int[] values = new int[size]; // store the user input
		int[] dp = new int[size];     // for dynamic programming
		for(int i=0 ; i<size ; i++)
			values[i] = key.nextInt();

		for(int i=0 ; i<size ; i++) {
			if(i == 0) dp[i] = values[i];
			else if(i == 1) dp[i] = dp[i-1] + values[i];
			else if(i == 2) dp[i] = findMax(values[i-2] + values[i-1], values[i-2] + values[i], values[i-1] + values[i]);
			else dp[i] = findMax(dp[i-1], dp[i-2] + values[i], dp[i-3] + values[i-1] + values[i]);
		}

		// print out the result
		System.out.println(dp[size-1]);

		key.close();
		System.exit(0);
	}

	public static int findMax(int num1, int num2, int num3) {
		if(num1 > num2 && num1 > num3)
			return num1;
		else if(num1 > num2 && num1 < num3)
			return num3;
		else if(num1 < num2 && num1 > num3)
			return num2;
		else {
			if(num2 > num3)
				return num2;
			else
				return num3;
		}
	}
}
