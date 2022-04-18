// BOJ - 1012
// Problem Sheet - https://www.acmicpc.net/problem/1012

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Location {
	private int x;
	private int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// getter
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int tcSize = key.nextInt(); // the number of test cases
		int w, h; // width & height
		int k; // the number of Cabbage
		int[][] map = new int[50][50];
		Queue<Location> q = new LinkedList<>(); // queue for bfs
		int[] xi = {0, 0, -1, 1}; // x-increment
		int[] yi = {-1, 1, 0, 0}; // y-increment
		int tCount = 0; // store the tmp count
		ArrayList<Integer> result = new ArrayList<>();

		for(int i=0 ; i<tcSize ; i++) {
			w = key.nextInt();
			h = key.nextInt();
			k = key.nextInt();
			// build the map
			for(int j=0 ; j<k ; j++) {
				int x = key.nextInt();
				int y = key.nextInt();
				map[y][x] = 1;
			}
			
			// bfs search
			for(int j=0 ; j<h ; j++) {
				for(int l=0 ; l<w ; l++) {
					if(map[j][l] == 1) {
						map[j][l] = 2;
						q.add(new Location(l, j));
						while(!q.isEmpty()) {
							int tx = q.peek().getX();
							int ty = q.peek().getY();
							for(int m=0 ; m<4 ; m++) {
								int curX = tx + xi[m];
								int curY = ty + yi[m];
								if(validation(curX, curY, w, h) && map[curY][curX] == 1) {
									map[curY][curX] = 2;
									q.add(new Location(curX, curY));
								}
							}
							q.poll();
						}
						tCount++;
					}
				}
			}
			result.add(tCount);
			tCount = 0; // initialize for reuse
		}

		for(int count : result)
			System.out.println(count);

		key.close();
		System.exit(0);
	}

	public static boolean validation(int x, int y, int w, int h) {
		if(x<0 || x>w-1 || y<0 || y>h-1)
			return false;
		return true;
	}
}
