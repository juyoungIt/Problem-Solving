// BOJ - 2644
// Problem Sheet - https://www.acmicpc.net/problem/2644

import java.util.Scanner;

public class Main {
	
	static int n; // number of people
	static int[][] relation; // relation between each people
	static int result = -1;   // store the 'chon' value
	static int[][] am; // adjacency matrix
	static boolean[] visit; // store the visit information

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		n = key.nextInt();
		int target1 = key.nextInt();
		int target2 = key.nextInt();
		int m = key.nextInt(); // the number of relations
		relation = new int[m][2];
		for(int i=0 ; i<m ; i++) {
			relation[i][0] = key.nextInt();
			relation[i][1] = key.nextInt();
		}

		// build adjacency matrix
		am = new int[n+1][n+1];
		visit = new boolean[n+1];
		for(int i=0 ; i<m ; i++) {
			am[relation[i][0]][relation[i][1]] = 1;
			am[relation[i][1]][relation[i][0]] = 1;
		}

		// perform the dfs
		dfs(target1, target2, 0);

		// print out the result
		System.out.println(result);

		key.close();
		System.exit(0);
	}

	public static void dfs(int sn, int en, int count) {
		
		if(sn == en) {
			result = count;
			return;	
		}
		
		visit[sn] = true;
		for(int i=1 ; i<n+1 ; i++) {
			if(am[sn][i] == 1 && !visit[i])
				dfs(i, en, count+1);
		}
	}
}
