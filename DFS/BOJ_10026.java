// BOJ - 10026
// Problem Sheet - https://www.acmicpc.net/problem/10026

import java.util.Scanner;
import java.util.Stack;

class Location {
	private int x; // x-coordinate
	private int y; // y-coordinate

	// constructor
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// getter
	public int getX() { return this.x; }
	public int getY() { return this.y; }
}

public class Main {
	
	static int n;			 // the size of picture
	static char[][] picture; // the picture map
	static char[][] storage; // the backup area of picture map
	static int yrgCount;     // 적록색약O
	static int nrgCount;     // 적록색약X
	static Stack<Location> s; 
	static int[] xi = {0, 0, -1, 1}; // x-increment
	static int[] yi = {-1, 1, 0, 0}; // y-increment
	static int tmpCount = 0;
	static char[] targets = {'R', 'G', 'B'}; // searching target

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		s = new Stack<>();
		n = key.nextInt();
		picture = new char[n][n];
		storage = new char[n][n];
		key.nextLine();
		for(int i=0 ; i<n ; i++) {
			String tmp = key.nextLine();
			for(int j=0 ; j<n ; j++) {
				picture[i][j] = tmp.charAt(j);
				storage[i][j] = tmp.charAt(j);
			}
		}
		
		// 적록색약X
		for(int i=0 ; i<3 ; i++) {
			for(int j=0 ; j<n ; j++) {
				for(int k=0 ; k<n ; k++) {
					if(picture[j][k] == targets[i]) {
						dfs(k, j, targets[i]);
						tmpCount++;
					}
				}
			}
		}
		nrgCount = tmpCount;
		tmpCount = 0; // for reuse

		// restore & pre-processing
		for(int i=0 ; i<n ; i++)
			for(int j=0 ; j<n ; j++)
				picture[i][j] = (storage[i][j] == 'R') ? 'G' : storage[i][j];

		// 적록색약O
		for(int i=1 ; i<3 ; i++) {
			for(int j=0 ; j<n ; j++) {
				for(int k=0 ; k<n ; k++) {
					if(picture[j][k] == targets[i]) {
						dfs(k, j, targets[i]);
						tmpCount++;	
					}
				}
			}
		}
		yrgCount = tmpCount;

		System.out.println(nrgCount + " " + yrgCount);

		key.close();
		System.exit(0);
	}

	public static void dfs(int sx, int sy, char target) {
		picture[sy][sx] = 'P'; // passed
		s.push(new Location(sx, sy));
		while(!s.isEmpty()) {
			int tx = s.peek().getX();
			int ty = s.peek().getY();
			for(int i=0 ; i<4 ; i++) {
				int curX = tx + xi[i];
				int curY = ty + yi[i];
				if(validation(curX, curY) && picture[curY][curX] == target)
					dfs(curX, curY, target);
			}
			if(!s.isEmpty())
				s.pop();
		}
	}

	public static boolean validation(int x, int y) {
		if(x<0 || x>n-1 || y<0 || y>n-1)
			return false;
		return true;
	}
}
