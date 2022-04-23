// BOJ - 11725
// Problem Sheet - https://www.acmicpc.net/problem/11725

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
	static int n;            // number of node
	static int[][] cInfo;    // connection info
	static ArrayList[] al;   // adjaceny list
	static int[] parents;    // parent node info
	static boolean[] visit;  // visit info

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		n = key.nextInt();
		al = new ArrayList[n+1];
		for(int i=1 ; i<n+1 ; i++)
			al[i] = new ArrayList<Integer>();
		visit = new boolean[n+1];
		cInfo = new int[n-1][2];
		for(int i=0 ; i<n-1 ; i++) {
			cInfo[i][0] = key.nextInt();
			cInfo[i][1] = key.nextInt();
		}
		parents = new int[n+1];

		// build adjacency list
		for(int i=0 ; i<n-1 ; i++) {
			al[cInfo[i][0]].add(cInfo[i][1]);
			al[cInfo[i][1]].add(cInfo[i][0]);
		}

		// perform the dfs
		dfs(1);

		// print out the results
		for(int i=2 ; i<n+1 ; i++)
			System.out.println(parents[i]);

		key.close();
		System.exit(0);
	}
	
	public static void dfs(int sn) {
		visit[sn] = true;
		for(int i=0 ; i<al[sn].size() ; i++) {
			int tmp = (int)al[sn].get(i);
			if(!visit[tmp]) {
				parents[tmp] = sn;
				dfs(tmp);
			}
		}
	}
}
