// BOJ - 6149
// Problem Sheet - https://www.acmicpc.net/problem/6149

import java.util.*;
import java.io.*;

public class Main {
	
	private static int N, K, P;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] row = br.readLine().split(" ");
		N = Integer.parseInt(row[0]);
		K = Integer.parseInt(row[1]);
		P = Integer.parseInt(row[2]);
		br.close();
	}

	private static String solve() {
		PriorityQueue<Integer> cards = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();

		Deque<Integer> deque = new ArrayDeque<>(K);
		for (int i=1 ; i<=K ; i++) {
			deque.addLast(i);
		}

		int seq = 0;
		while (!deque.isEmpty()) {
			if (seq == N-1) cards.add(deque.pollFirst());
			else deque.pollFirst();
			seq = (seq + 1) % N;
			if (deque.isEmpty()) break;
			for (int i=0 ; i<P ; i++) {
				deque.addLast(deque.pollFirst());
			}
		}

		while (!cards.isEmpty()) {
			sb.append(cards.poll()).append("\n");
		}
		return sb.toString();
	}

}