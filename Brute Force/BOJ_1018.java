// BOJ - 1018
// Problem Sheet - https://www.acmicpc.net/problem/1018

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int m = key.nextInt();
		int n = key.nextInt();
		String tmp;
		boolean[][] board = new boolean[m][n];
		key.nextLine();
		for(int i=0 ; i<m ; i++) {
			tmp = key.nextLine();
			for(int j=0 ; j<n ; j++)
				board[i][j] = (tmp.charAt(j) == 'W') ? true : false;
		}
		int minCount = 64; // the minimum number of coloring
		int tmpCount = 0;  // store the temporary counting result
		boolean curColor;

		// counting logic
		for(int i=0 ; i<m-7 ; i++) {
			for(int j=0 ; j<n-7 ; j++) {
				// search the available board - start point : white
				curColor = true;
				for(int k=i ; k<i+8 ; k++) {
					for(int l=j ; l<j+8 ; l++) {
						if(board[k][l] != curColor)
							tmpCount++;
						curColor = !curColor;
					}
					curColor = !curColor;
				}
				if(minCount > tmpCount)
					minCount = tmpCount;
				tmpCount = 0;

				// search the available board - start point : black
				curColor = false;
				for(int k=i ; k<i+8 ; k++) {
					for(int l=j ; l<j+8 ; l++) {
						if(board[k][l] != curColor)
							tmpCount++;
						curColor = !curColor;
					}
					curColor = !curColor;
				}
				if(minCount > tmpCount)
					minCount = tmpCount;
				tmpCount = 0;
			}
		}

		// print out the result
		System.out.println(minCount);

		key.close(); // close the Scanner
		System.exit(0);
	}
}
