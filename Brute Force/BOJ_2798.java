// BOJ - 2798
// Problem Sheet - https://www.acmicpc.net/problem/2798

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int n = key.nextInt();    // number of cards
		int m = key.nextInt();    // thresholds
		int[] cards = new int[n]; // card values
		for(int i=0 ; i<n ; i++)
			cards[i] = key.nextInt();
		int tmpSum, tmpDiff;
		int minDiff = m;
		int result = 0;

		for(int i=0 ; i<n-2 ; i++) {
			for(int j=i+1 ; j<n-1 ; j++) {
				for(int k=j+1 ; k<n ; k++) {
					tmpSum = cards[i] + cards[j] + cards[k];
					tmpDiff = m - tmpSum;
					if(tmpDiff >=0 && tmpDiff < minDiff) {
						minDiff = tmpDiff;
						result = tmpSum;
					}
				}
			}
		}

		System.out.println(result);

		key.close();
		System.exit(0);
	}
}
