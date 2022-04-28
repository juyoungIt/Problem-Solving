// BOJ - 11724
// Problem Sheet - https://www.acmicpc.net/problem/11724

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int vn = key.nextInt(); // the number of vertex
		int en = key.nextInt(); // the number of edge
		int[][] am = new int[vn+1][vn+1]; // adjacency matrix
		for(int i=0 ; i<en ; i++) {
			int x = key.nextInt(); // vertex identifier1
			int y = key.nextInt(); // vertex identifier2
			am[x][y] = 1;
			am[y][x] = 1;
		}
		boolean[] visit = new boolean[vn+1]; // visit information for each vertex
		int cn = 0; // the number of connected components

		// perform the dfs search
		for(int i=1 ; i<vn+1 ; i++) {
			if(visit[i] == false) {
				dfs_search(am, visit, i);
				cn++; // count connected components
			}
		}

		System.out.println(cn);

		key.close(); // close the scanner
		System.exit(0);
	}

	// dfs algorithm
	public static void dfs_search(int[][] am, boolean[] visit, int start) {
		
		int size = am.length;
		visit[start] = true;

		for(int i=1 ; i<size ; i++) {
			if(am[start][i] == 1 && visit[i] == false)
				dfs_search(am, visit, i);
		}
	}
}
