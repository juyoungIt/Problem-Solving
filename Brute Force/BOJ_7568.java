// BOJ - 7568
// Problem Sheet - https://www.acmicpc.net/problem/7568

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int n = key.nextInt(); // the number of people
		int[][] sizeInfo = new int[n][2]; // store the each size of people
		for(int i=0 ; i<n ; i++) {
			sizeInfo[i][0] = key.nextInt();
			sizeInfo[i][1] = key.nextInt();
		}
		int[] ranks = new int[n]; // the rank of each people
		int bigger = 0; // store the number of more bigger man
		
		// search the all data
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(i == j) continue;
				if(sizeInfo[i][0] < sizeInfo[j][0] && sizeInfo[i][1] < sizeInfo[j][1])
					bigger++;
			}
			ranks[i] = bigger + 1;
			bigger = 0;
		}

		// print out the rank result
		for(int rank : ranks)
			System.out.print(rank + " ");
		System.out.println();

		key.close(); // close the scanner
		System.exit(0);
	}
}
