// BOJ - 1987
// Problem Sheet - https://www.acmicpc.net/problem/1987

import java.util.Scanner;

class Location {
	private int x; // x-coordinate
	private int y; // y-coordinate

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() { return this.x; }
	public int getY() { return this.y; }
}

public class Main {

	static int r; // height
	static int c; // width
	static char[][] board; // board
	static boolean[][] visit; // store the visit information
	static boolean[] alpha;   // store the alphabet using info
 
	static int[] xi = {0, 0, -1, 1}; // x-increment
	static int[] yi = {-1, 1, 0, 0}; // y-increment
	static int count = 0;            // store the counting value
	static int maxCount = 0;         // store the maximum counting value

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		r = key.nextInt();
		c = key.nextInt();
		
		board = new char[r][c];
		visit = new boolean[r][c];
		alpha = new boolean[26];
		key.nextLine();
		for(int i=0 ; i<r ; i++) {
			String tmp = key.nextLine();
			for(int j=0 ; j<c ; j++)
				board[i][j] = tmp.charAt(j);
		}

		dfs(0, 0); // start from the left corner
	
		System.out.println(maxCount);

		System.exit(0);
	}

	public static void dfs(int sx, int sy) {
		visit[sy][sx] = true;
		alpha[board[sy][sx]-'A'] = true;
		count++;
		
		for(int i=0 ; i<4 ; i++) {
			int curX = sx + xi[i];
			int curY = sy + yi[i];
			if(validation(curX, curY) && !visit[curY][curX] && !alpha[board[curY][curX]-'A'])
				dfs(curX, curY);
		}

		// backtracking
		visit[sy][sx] = false;
		alpha[board[sy][sx]-'A'] = false;
		if(count > maxCount)
			maxCount = count;
		count--;
	}

	public static boolean validation(int x, int y) {
		if(x<0 || x>c-1 || y<0 || y>r-1)
			return false;
		return true;
	}
}
