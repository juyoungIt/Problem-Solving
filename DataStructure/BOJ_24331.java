// BOJ - 24331
// Problem Sheet - https://www.acmicpc.net/problem/24331

import java.util.*;
import java.io.*;

public class Main {

	private static int n, m;
	private static int[] a, b;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] row = br.readLine().split(" ");
		n = Integer.parseInt(row[0]);
		m = Integer.parseInt(row[1]);
		a = new int[n];
		b = new int[m];
		row = br.readLine().split(" ");
		for (int i=0 ; i<n ; i++) a[i] = Integer.parseInt(row[i]);
		row = br.readLine().split(" ");
		for (int i=0 ; i<m ; i++) b[i] = Integer.parseInt(row[i]);
		br.close();
	}

	private static String solve() {
		Set<Integer> stamps = new HashSet<>();
		for (int i=0 ; i<n ; i++) {
			stamps.add(a[i]);
		}
		List<Integer> duples = new ArrayList<>();
		for (int i=0 ; i<m ; i++) {
			if (stamps.contains(b[i])) {
				duples.add(b[i]);
			}
		}
		Collections.sort(duples);
		StringBuilder sb = new StringBuilder();
		sb.append(duples.size()).append("\n");
		duples.forEach(s -> sb.append(s).append(" "));
		return sb.toString();
	}

}
