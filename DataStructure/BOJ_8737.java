// BOJ - 8737
// Problem Sheet - https://www.acmicpc.net/problem/8737

import java.util.*;
import java.io.*;

public class Main {

	private static int n, k;
	private static String cmd;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] row = br.readLine().split(" ");
		n = Integer.parseInt(row[0]);
		k = Integer.parseInt(row[1]);
		cmd = br.readLine();
		br.close();
	}

	private static int solve() {
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i=1 ; i<=n ; i++) {
			deque.addLast(i);
		}
		for (int i=0 ; i<k ; i++) {
			if (cmd.charAt(i) == 'A') {
				deque.addLast(deque.pollFirst());
			} else {
				int top = deque.pollFirst();
				deque.addLast(deque.pollFirst());
				deque.addFirst(top);
			}
		}
		return deque.peekFirst();
	}

}
