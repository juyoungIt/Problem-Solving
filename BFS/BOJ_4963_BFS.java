// BOJ - 4963
// Problem Sheet - https://www.acmicpc.net/problem/4963

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
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
	static Queue<Location> q; // queue for the bfs algorithm

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

			// perform the bfs algorithm
			q = new LinkedList<>(); // initialize stack
			count = 0;
			for(int i=0 ; i<h ; i++) {
				for(int j=0 ; j<w ; j++) {
					if(map[i][j] == 1) {
						map[i][j] = 2;
						q.add(new Location(j, i));
						while(q.isEmpty() == false) {
							int tx = q.peek().getX(); // front X
							int ty = q.peek().getY(); // front Y
							for(int k=0 ; k<8 ; k++) {
								int curX = tx + xi[k];
								int curY = ty + yi[k];
								if(validation(curX, curY) && map[curY][curX] == 1) {
									map[curY][curX] = 2;
									q.add(new Location(curX, curY));
								}
							}
							if(q.isEmpty() == false)
								q.poll();
						}
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

	// coordinate validation
	public static boolean validation(int x, int y) {
		if(x<0 || x>w-1 || y<0 || y>h-1)
			return false;
		return true;
	}
}
