// BOJ - 2096
// Problem Sheet - https://www.acmicpc.net/problem/2096

import java.util.*;
import java.io.*;

public class Main {

	private static int N;
	private static int[][] board;
	private static int[][] dpMin, dpMax;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][5];
		for (int i=0 ; i<N ; i++) {
			String[] row = br.readLine().split(" ");
			for (int j=1 ; j<=3 ; j++) {
				board[i][j] = Integer.parseInt(row[j - 1]);
			}
		}
		dpMin = new int[N][5];
		for (int i=0 ; i<N ; i++) {
			Arrays.fill(dpMin[i], 900_001);
		}
		dpMax = new int[N][5];
		br.close();
	}

	private static String solve() {
		for (int i=1 ; i<=3 ; i++) {
			dpMin[0][i] = dpMax[0][i] = board[0][i];
		}
		for (int i=1 ; i<N ; i++) {
			for (int j=1 ; j<=3 ; j++) {
				dpMin[i][j] = board[i][j]
						+ Math.min(dpMin[i - 1][j - 1], Math.min(dpMin[i - 1][j], dpMin[i - 1][j + 1]));
				dpMax[i][j] = board[i][j]
						+ Math.max(dpMax[i - 1][j - 1], Math.max(dpMax[i - 1][j], dpMax[i - 1][j + 1]));
			}
		}
		int max = Math.max(dpMax[N - 1][1], Math.max(dpMax[N - 1][2], dpMax[N - 1][3]));
		int min = Math.min(dpMin[N - 1][1], Math.min(dpMin[N - 1][2], dpMin[N - 1][3]));
		return max + " " + min;
	}
}