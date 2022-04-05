// BOJ - 11724
// Problem Sheet - https://www.acmicpc.net/problem/11724

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

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
		Queue<Integer> q = new LinkedList<>(); // queue for bfs algorithm
		int cn = 0; // the number of connected components

		// perform the bfs search
		for(int i=1 ; i<vn+1 ; i++) {
			if(visit[i] == false) {
				bfs_search(am, visit, q, i);
				cn++; // count connected components
			}
		}

		System.out.println(cn);

		key.close(); // close the scanner
		System.exit(0);
	}

	// bfs algorithm
	public static void bfs_search(int[][] am, boolean[] visit, Queue<Integer> q, int start) {
		
		int size = am.length;
		visit[start] = true;
		q.add(start);

		while(q.isEmpty() == false) {
			int tmp = q.peek();
			for(int i=1 ; i<size ; i++) {
				if(am[tmp][i] == 1 && visit[i] == false) {
					visit[i] = true;
					q.add(i);
				}
			}
			q.poll();
		}
	}
}
