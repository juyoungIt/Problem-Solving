// BOJ - 2606
// Problem Sheet - https://www.acmicpc.net/problem/2606

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int vn = key.nextInt(); // the number of computers - vertex
		int en = key.nextInt(); // the number of connections - edge
		int[][] vr = new int[en][2]; // relation of computers
		int[][] am = new int[vn+1][vn+1]; // adjacency matrix of computers
		boolean[] visited = new boolean[vn]; // visit information
		Queue<Integer> q = new LinkedList<>(); // queue for bfs
		int count = 0; // the number of infected computers
		for(int i=0 ; i<en ; i++) {
			vr[i][0] = key.nextInt();
			vr[i][1] = key.nextInt();
		}

		// build adjacency matrix
		for(int i=0 ; i<en ; i++) {
			am[vr[i][0]][vr[i][1]] = 1;
			am[vr[i][1]][vr[i][0]] = 1;
		}

		visited[0] = true;
		q.add(1);
		while(!q.isEmpty()) {
			int tmp = q.peek();
			for(int i=1 ; i<vn+1 ; i++) {
				if(am[tmp][i] == 1 && visited[i-1] == false) {
					visited[i-1] = true;
					q.add(i);
					count++;
				}
			}
			q.poll();
		}
		
		System.out.println(count);

		key.close();
		System.exit(0);
	}
}
