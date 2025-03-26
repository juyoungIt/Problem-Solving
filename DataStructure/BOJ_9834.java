// BOJ - 9834
// Problem Sheet - https://www.acmicpc.net/problem/9834

import java.util.*;
import java.io.*;

public class Main {

	private static int m, k;
	private static String seq;
	private static Deque<Integer> deque;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		m = Integer.parseInt(input[0]);
		k = Integer.parseInt(input[1]);
		seq = input[2];
		deque = new ArrayDeque<>(m);
		for (int i=0 ; i<m ; i++) {
			deque.addLast(i);
		}
		br.close();
	}

	private static String solve() {
		StringBuilder sb = new StringBuilder();
		for (int i=0 ; i<seq.length()-1 ; i++) {
			if (seq.charAt(i) == 'A') {
				deque.addLast(deque.pollFirst());
			} else if (seq.charAt(i) == 'B') {
				int top = deque.pollFirst();
				deque.addLast(deque.pollFirst());
				deque.addFirst(top);
			} else {
				throw new IllegalArgumentException("invalid seq");
			}
		}

		for (int i=0 ; i<k-1 ; i++) {
			deque.addLast(deque.pollFirst());
		}
		for (int i=0 ; i<3 ; i++) {
			sb.append(deque.pollFirst()).append(" ");
		}
		return sb.toString();
	}
}