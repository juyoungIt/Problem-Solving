// BOJ - 1520
// Problem Sheet - https://www.acmicpc.net/problem/1520

import java.util.Scanner;

public class Main {
	
	static int m; // height
	static int n; // width
	static int[][] map;
	static boolean[][] visit; // store the visit information
	static int result = 0;
	
	static int[] xi = {-1, 1, 0, 0}; // x-increment
	static int[] yi = {0, 0, -1, 1}; // y-increment

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		m = key.nextInt();
		n = key.nextInt();
		map = new int[m][n];
		visit = new boolean[m][n];
		for(int i=0 ; i<m ; i++)
			for(int j=0 ; j<n ; j++)
				map[i][j] = key.nextInt();

		// peform the dfs
		dfs(0, 0);

		// print out the result
		System.out.println(result);

		key.close();
		System.exit(0);
	}

	public static void dfs(int sx, int sy) {

		// arrived!
		if(sx == n-1 && sy == m-1)
			result++;
		
		visit[sy][sx] = true;
		for(int i=0 ; i<4 ; i++) {
			int curX = sx + xi[i];
			int curY = sy + yi[i];
			if(validation(curX, curY) && map[curY][curX] < map[sy][sx] && !visit[curY][curX])
				dfs(curX, curY);
		}
		// backtracking
		visit[sy][sx] = false;
	}

	public static boolean validation(int x, int y) {
		if(x<0 || x>n-1 || y<0 || y>m-1)
			return false;
		return true;
	}
}
