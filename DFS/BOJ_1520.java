// BOJ - 1520
// Problem Sheet - https://www.acmicpc.net/problem/1520

import java.util.Scanner;

public class Main {
	
	static int m; // height
	static int n; // width
	static int[][] map;
	static int[][] dp; // for dynamic programming
	static boolean[][] visit; // store the visit information
	
	static int[] xi = {-1, 1, 0, 0}; // x-increment
	static int[] yi = {0, 0, -1, 1}; // y-increment

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		m = key.nextInt();
		n = key.nextInt();
		map = new int[m][n];
		dp = new int[m][n];
		visit = new boolean[m][n];
		for(int i=0 ; i<m ; i++) {
			for(int j=0 ; j<n ; j++) {
				map[i][j] = key.nextInt();
				dp[i][j] = -1; // initialization
			}
		}

		// print out the result
		System.out.println(dfs(0, 0));

		key.close();
		System.exit(0);
	}

	public static int dfs(int sx, int sy) {

		// arrived!
		if(sx == n-1 && sy == m-1)
			return 1;

		if(dp[sy][sx] != -1)
			return dp[sy][sx];
		
		visit[sy][sx] = true;
		dp[sy][sx] = 0;
		for(int i=0 ; i<4 ; i++) {
			int curX = sx + xi[i];
			int curY = sy + yi[i];
			if(validation(curX, curY) && map[curY][curX] < map[sy][sx] && !visit[curY][curX])
				dp[sy][sx] += dfs(curX, curY);
		}
		// backtracking
		visit[sy][sx] = false;
		return dp[sy][sx];
	}

	public static boolean validation(int x, int y) {
		if(x<0 || x>n-1 || y<0 || y>m-1)
			return false;
		return true;
	}
}
