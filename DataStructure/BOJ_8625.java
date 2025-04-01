// BOJ - 8625
// Problem Sheet - https://www.acmicpc.net/problem/8625

import java.util.*;
import java.io.*;

public class Main {

	private static int n;
	private static long k;
	private static Set<Long> numbers;
	private static long max = 0L;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Long.parseLong(st.nextToken());
		numbers = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i=0 ; i<n ; i++) {
			long element = Long.parseLong(st.nextToken());
			numbers.add(element);
			max = Math.max(max, element);
		}
		br.close();
	}

	private static long solve() {
		long multiple = 1;
		while (true) {
			long candidate = k * multiple;
			if (!numbers.contains(candidate)) {
				return candidate;
			}
			multiple++;
		}
	}

}