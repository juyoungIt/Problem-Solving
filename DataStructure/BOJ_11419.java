// BOJ - 11419
// Problem Sheet - https://www.acmicpc.net/problem/11419

import java.util.*;
import java.io.*;

public class Main {	
	
	private static int n, k;
	private static int[] c;
	private static Map<Integer, Integer> g;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] row = br.readLine().split(" ");
		n = Integer.parseInt(row[0]);
		k = Integer.parseInt(row[1]);
		c = new int[n];
		for (int i=0 ; i<n ; i++) {
			c[i] = Integer.parseInt(br.readLine());
		}
		g = new HashMap<>();
		br.close();
	}

	private static int solve() {
		for (int i=0 ; i<n ; i++) {
			g.put(c[i], g.getOrDefault(c[i], 0) + 1);
		}
		int u = -1;
		for (Map.Entry<Integer, Integer> e : g.entrySet()) {
			if (e.getValue() % k != 0) {
				u = e.getKey();
				break;
			}
		}
		return u;
	}

}
