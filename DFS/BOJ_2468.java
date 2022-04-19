// BOJ - 2468
// Problem Sheet - https://www.acmicpc.net/problem/2468

import java.util.Scanner;
import java.util.Stack;

class Location {
	private int x;
	private int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() { return this.x; }
	public int getY() { return this.y; }
}

public class Main {

	static Stack<Location> s = new Stack<>();
	static int size;     // the map size
	static int[][] map;  // the map
	static int[][] sink; // the sink area information (0 : sink)
	static int maxH;	 // the maximum height on the map
	static int maxSafe;  // the maximum number of safe area
	static int tmp;      // the temporary space for the calculation
	static int[] xi = {0, 0, -1, 1}; // the x-increment
	static int[] yi = {-1, 1, 0, 0}; // the y-increment

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		size = key.nextInt();
		map = new int[size][size];  // build map area
		sink = new int[size][size]; // build sink info area
		maxH = 0;
		maxSafe = 0;
		tmp = 0;
		for(int i=0 ; i<size ; i++) {
			for(int j=0 ; j<size ; j++) {
				map[i][j] = key.nextInt();
				if(map[i][j] > maxH)
					maxH = map[i][j];
			}
		}
		
		// search the available cases
		for(int i=0 ; i<=maxH ; i++) {
			// update sink information
			for(int j=0 ; j<size ; j++)
				for(int k=0 ; k<size ; k++)
					sink[j][k] = (map[j][k] <= i) ? 0 : 1;
			// perform dfs
			for(int j=0 ; j<size ; j++) {
				for(int k=0 ; k<size ; k++) {
					if(sink[j][k] == 1) {
						dfs(k, j);
						tmp++;
					}	
				}	
			}
			// check maximum cases
			if(maxSafe < tmp)
				maxSafe = tmp;
			tmp = 0; // initialize for reuse
		}

		System.out.println(maxSafe);

		key.close();
		System.exit(0);
	}

	public static void dfs(int sx, int sy) {
		sink[sy][sx] = 2;
		s.add(new Location(sx, sy));
		while(!s.isEmpty()) {
			int tx = s.peek().getX();
			int ty = s.peek().getY();
			for(int i=0 ; i<4 ; i++) {
				int curX = tx + xi[i];
				int curY = ty + yi[i];
				if(validation(curX, curY) && sink[curY][curX] == 1)
					dfs(curX, curY);
			}
			if(!s.isEmpty())
				s.pop();
		}
	}

	public static boolean validation(int x, int y) {
		if(x<0 || x>size-1 || y<0 || y>size-1)
			return false;
		return true;
	}
}
