// BOJ - 2583
// Problem Sheet - https://www.acmicpc.net/problem/2583

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
	
	static int m; // height
	static int n; // width
	static int k; // number of rect

	static int[][] cInfo;     // coordinate information
	static boolean[][] paper; // paper board
	static boolean[][] visit;     // visit information

	static int tmpArea = 0;  // store the middle count
	static int count = 0;    // number of area
	static ArrayList<Integer> areas; // area value on the paper

	static int[] xi = {0, 0, -1, 1}; // x-increment
	static int[] yi = {-1, 1, 0, 0}; // y-increment

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		m = key.nextInt();
		n = key.nextInt();
		k = key.nextInt();
		cInfo = new int[k][4];
		paper = new boolean[m][n];
		visit = new boolean[m][n];
		areas = new ArrayList<>();
		for(int i=0 ; i<k ; i++)
			for(int j=0 ; j<4 ; j++)
				cInfo[i][j] = key.nextInt();
		
		// initalization
		for(int i=0 ; i<m ; i++)
			for(int j=0 ; j<n ; j++)
				paper[i][j] = true;

		// build paper information
		for(int i=0 ; i<k ; i++) {
			int x1 = cInfo[i][0];
			int y1 = cInfo[i][1];
			int x2 = cInfo[i][2];
			int y2 = cInfo[i][3];
			for(int j=m-y2 ; j<m-y1 ; j++)
				for(int k=x1 ; k<x2 ; k++)
					paper[j][k] = false;
		}

		// perform bfs
		for(int i=0 ; i<m ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(paper[i][j] && !visit[i][j]) {
					dfs(j, i);
					count++;
					areas.add(tmpArea);
					tmpArea = 0; // for reuse
				}
			}
		}

		// print out the result
		System.out.println(count);
		Collections.sort(areas);
		for(int area : areas)
			System.out.print(area + " ");
		System.out.println();

		key.close();
		System.exit(0);
	}

	public static void dfs(int sx, int sy) {
		visit[sy][sx] = true;
		tmpArea++;
		for(int i=0 ; i<4 ; i++) {
			int curX = sx + xi[i];
			int curY = sy + yi[i];
			if(validation(curX, curY) && paper[curY][curX] && !visit[curY][curX])
				dfs(curX, curY);
		}
	}

	public static boolean validation(int x, int y) {
		if(x<0 || x>n-1 || y<0 || y>m-1)
			return false;
		return true;
	}
}
