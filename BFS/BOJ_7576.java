// BOJ - 7576
// Problem Sheet - https://www.acmicpc.net/problem/7576

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

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
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int m = key.nextInt(); // width
		int n = key.nextInt(); // height
		int[][] frame = new int[n][m];
		boolean[][] visit = new boolean[n][m]; // visit info
		Queue<Location> q = new LinkedList<>();
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<m ; j++) {
				frame[i][j] = key.nextInt();	
				if(frame[i][j] == 1) {
					visit[i][j] = true;
					q.add(new Location(j, i));
				}
			}
		}
		int[] xi = {0, 0, -1, 1};
		int[] yi = {-1, 1, 0, 0};
		int days = 0;

		// bfs search		
		while(!q.isEmpty()) {
			int tx = q.peek().getX();
			int ty = q.peek().getY();
			for(int k=0 ; k<4 ; k++) {
				int curX = tx + xi[k];
				int curY = ty + yi[k];
				if(validation(curX, curY, m, n) && !visit[curY][curX] && frame[curY][curX] == 0) {
					visit[curY][curX] = true;
					frame[curY][curX] = frame[ty][tx] + 1;
					q.add(new Location(curX, curY));
				}
			}
			q.poll();
		}
		
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<m ; j++) {
				if(frame[i][j] == 0) {
					System.out.println("-1");
					System.exit(0);
				}
				else if(days < frame[i][j])
					days = frame[i][j];
			}
		}

		System.out.println(days-1);

		key.close();
		System.exit(0);
	}

	public static boolean validation(int x, int y, int m, int n) {
		if(x<0 || x>m-1 || y<0 || y>n-1)
			return false;
		return true;
	}
}
