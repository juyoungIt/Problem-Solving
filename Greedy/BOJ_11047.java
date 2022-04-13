// BOJ - 11047
// Problem Sheet - https://www.acmicpc.net/problem/11047

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int n = key.nextInt(); // the number of coins
		int k = key.nextInt(); // values
		int[] values = new int[n]; // the unit of coins
		for(int i=0 ; i<n ; i++)
			values[i] = key.nextInt();
		int counts = 0; // the minimum number of coins
		int tmp = 0;    // cache for the calculation
		
		// find the optimal solutions
		for(int i=n-1 ; i>=0 ; i--) {
			if(tmp == k) break;
			if(values[i] <= k-tmp) {
				counts += (k-tmp)/values[i];
				tmp += values[i] * ((k-tmp)/values[i]);
			}
		}

		System.out.println(counts);

		key.close();
		System.exit(0);
	}
}
