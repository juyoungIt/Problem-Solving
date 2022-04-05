// BOJ - 4963
// Problem Sheet - https://www.acmicpc.net/problem/4963

import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

class Location {
	private int x; // x-coordinate
	private int y; // y-coordinate

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}

public class Main {

	static int w; // width of the map
	static int h; // height of the map
	static int[] xi = {-1, 0 , 1, 1, 1, 0 , -1, -1}; // x increment
	static int[] yi = {-1, -1, -1, 0, 1, 1, 1, 0};   // y increment
	static Stack<Location> s; // stack for the dfs algorithm

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int count = 0; // number of islands
		ArrayList<Integer> counts = new ArrayList<>();

		while(true) {

			w = key.nextInt();
			h = key.nextInt();

			if(w == 0 && h == 0) break;

			int[][] map = new int[h][w]; // map (0: 불가, 1:지남X, 2:지남O)
			for(int i=0 ; i<h ; i++) {
				for(int j=0 ; j<w ; j++)
					map[i][j] = key.nextInt();
			}

			// perform the dfs algorithm
			s = new Stack<>(); // initialize stack
			count = 0;
			for(int i=0 ; i<h ; i++) {
				for(int j=0 ; j<w ; j++) {
					if(map[i][j] == 1) {
						dfs_search(map, j, i);
						count++;
					}
				}
			}
			counts.add(count);
		}

		// print the result
		for(int num : counts)
			System.out.println(num);

		key.close(); // close the scanner
		System.exit(0);
	}

	public static void dfs_search(int[][] map, int sx, int sy) {
		
		map[sy][sx] = 2;
		s.push(new Location(sx, sy));

		while(s.isEmpty() == false) {
			int tx = s.peek().getX(); // top X
			int ty = s.peek().getY(); // top Y
			for(int i=0 ; i<8 ; i++) {
				int curX = tx + xi[i];
				int curY = ty + yi[i];
				if(validation(curX, curY) && map[curY][curX] == 1)
					dfs_search(map, curX, curY);
			}
			if(s.isEmpty() == false)
				s.pop();
		}
	}

	// coordinate validation
	public static boolean validation(int x, int y) {
		if(x<0 || x>w-1 || y<0 || y>h-1)
			return false;
		return true;
	}
}
