// BOJ - 2667
// Problem Sheet - https://www.acmicpc.net/problem/2667

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

class Location {
	private int x; // x-coordinate
	private int y; // y-coordinate

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
		int size = key.nextInt(); // map size
		int[][] map = new int[size][size];
		String tmp;
		key.nextLine();
		for(int i=0 ; i<size ; i++) {
			tmp = key.nextLine();
			for(int j=0 ; j<tmp.length() ; j++)
				if(tmp.charAt(j) == '1')
					map[i][j] = 1;
		}
		int[] xi = {0, 0, -1, 1}; // x-increment
		int[] yi = {-1, 1, 0, 0}; // y-increment

		// search by using bfs algorithm
		Queue<Location> q = new LinkedList<>(); // queue for bfs
		int tmpCount = 0;
		ArrayList<Integer> counts = new ArrayList<>(); // store the town count
		for(int i=0 ; i<size ; i++) {
			for(int j=0 ; j<size ; j++) {
				if(map[i][j] == 1) {
					map[i][j] = 2; // visit
					tmpCount++;
					q.add(new Location(j, i));
					while(!q.isEmpty()) {
						int tx = q.peek().getX();
						int ty = q.peek().getY();
						for(int k=0 ; k<4 ; k++) {
							int curX = tx + xi[k];
							int curY = ty + yi[k];
							if(validation(curX, curY, size) && map[curY][curX] == 1) {
								map[curY][curX] = 2;
								tmpCount++;
								q.add(new Location(curX, curY));
							}
						}
						q.poll();
					}
					counts.add(tmpCount);
					tmpCount = 0; // initialize for reusing
				}
			}
		}

		Collections.sort(counts); // sort the counts	
		System.out.println(counts.size()); // the number of complex
		for(int count : counts)
			System.out.println(count);

		key.close();
		System.exit(0);
	}

	public static boolean validation(int x, int y, int size) {
		if(x<0 || x>=size || y<0 || y>=size)
			return false;
		else
			return true;
	}
}
