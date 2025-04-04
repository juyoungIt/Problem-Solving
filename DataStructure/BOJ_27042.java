// BOJ - 12865
// Problem Sheet - https://www.acmicpc.net/problem/12865

import java.util.*;
import java.io.*;

public class Main {	

	private static int n;
	private static Queue<Integer> queue;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		queue = new ArrayDeque<>(n);
		br.close();
	}

	private static int solve() {
		for (int i=1 ; i<=n ; i++) {
			queue.add(i);
		}
		while (queue.size() != 1) {
			queue.add(queue.poll());
			queue.poll();
		}
		return queue.poll();
	}

}
