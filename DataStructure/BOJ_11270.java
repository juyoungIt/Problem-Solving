// BOJ - 11270
// Problem Sheet - https://www.acmicpc.net/problem/11270

import java.util.*;
import java.io.*;

public class Main {

	private static int n, k;
	private static int[] r;
	private static final int PROC_TIME = 1_000;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] row = br.readLine().split(" ");
		n = Integer.parseInt(row[0]);
		k = Integer.parseInt(row[1]);
		r = new int[n];
		for (int i=0 ; i<n ; i++) {
			r[i] = Integer.parseInt(br.readLine());
		}
		br.close();
	}

	private static int solve() {
		Deque<Integer> deque = new ArrayDeque<>(n);
		int concurrentSize = 0;
		for (int i=0 ; i<n ; i++) {
			deque.addLast(r[i]);
			while (deque.peekFirst() + PROC_TIME <= deque.peekLast()) {
				deque.pollFirst();
			}
			concurrentSize = Math.max(concurrentSize, deque.size());
		}
		return concurrentSize / k + (concurrentSize % k == 0 ? 0 : 1);
	}

}
