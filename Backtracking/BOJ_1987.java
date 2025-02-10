// BOJ - 1987
// Problem Sheet - https://www.acmicpc.net/problem/1987

import java.io.*;

public class Main {

	private static int R, C;
	private static int[][] board;
	private static int[][] routes;
	private static final boolean[] isUsed = new boolean[26];
	private static final int[] xi = { -1, 1, 0, 0 };
	private static final int[] yi = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
		input();
		isUsed[board[0][0]] = true;
		routes[0][0] = 1 << board[0][0];
		System.out.println(solve(0, 0));
    }

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		board = new int[R][C];
		routes = new int[R][C];
		for (int i=0 ; i<R ; i++) {
			String row = br.readLine();
			for (int j=0 ; j<C ; j++) {
				board[i][j] = row.charAt(j) - 'A';
			}
		}
		br.close();
	}

	private static int solve(int x, int y) {
		int maxDepth = 0;
		for (int i=0 ; i<4 ; i++) {
			int newX = x + xi[i];
			int newY = y + yi[i];
			if (!isValid(newX, newY)) continue;
			if (isUsed[board[newY][newX]]) continue;
			if (routes[newY][newX] == (routes[y][x] | 1 << board[newY][newX])) continue;
			routes[newY][newX] = routes[y][x] | 1 << board[newY][newX];
			isUsed[board[newY][newX]] = true;
			maxDepth = Math.max(maxDepth, solve(newX, newY));
			isUsed[board[newY][newX]] = false;
		}
		return maxDepth + 1;
	}

	private static boolean isValid(int x, int y) {
		return x>=0 && y>=0 && x<C && y<R;
	}
}