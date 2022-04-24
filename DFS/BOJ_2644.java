// BOJ - 2644
// Problem Sheet - https://www.acmicpc.net/problem/2644

import java.util.Scanner;

public class Main {
	
	static int n;  // the number of whole people
	static int t1; // target1
	static int t2; // target2
	static int m;  // the number of relations
	static int[][] r; // the relation information
	static int[][] am; // adjaceny matrix
	static boolean[] v; // store the visit info
	static int count = 0; // store the 'chon' count
	static boolean isFound = false;

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		n = key.nextInt();
		t1 = key.nextInt();
		t2 = key.nextInt();
		m = key.nextInt();
		am = new int[n+1][n+1];
		v = new boolean[n+1];
		r = new int[m][2];
		for(int i=0 ; i<m ; i++) {
			r[i][0] = key.nextInt();
			r[i][1] = key.nextInt();
		}

		// build adjacency matrix
		for(int i=0 ; i<m ; i++) {
			am[r[i][0]][r[i][1]] = 1;
			am[r[i][1]][r[i][0]] = 1;
		}

		// perform the dfs search
		dfs(t1, t2);

		// print out the result
		if(isFound) System.out.println(count);
		else System.out.println("-1");

		key.close();
		System.exit(0);
	}

	public static void dfs(int sn, int en) {
		if(sn == en)
			isFound = true;
		v[sn] = true;
		for(int i=1 ; i<n+1 ; i++) {
			if(isFound)
				break;
			if(am[sn][i] == 1 && !v[i]) {
				count++;	
				dfs(i, en);
			}
		}
	}
}
