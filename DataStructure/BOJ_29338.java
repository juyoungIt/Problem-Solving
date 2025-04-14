// BOJ - 29338
// Problem Sheet - https://www.acmicpc.net/problem/29338

import java.util.*;
import java.io.*;

public class Main {

	private static int n;
	private static String[] cmd;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		cmd = new String[n];
		for (int i=0 ; i<n ; i++) {
			cmd[i] = br.readLine();
		}
		br.close();
	}

	private static String solve() {
		Deque<Integer> table = new ArrayDeque<>(n);
		for (int i=0 ; i<n ; i++) {
			String[] token = cmd[i].split(" ");
			if (token[0].equals("add")) {
				table.addLast(Integer.parseInt(token[1]));
			} else if (token[0].equals("take")) {
				if (table.isEmpty()) continue;
				table.pollLast();
			} else if (token[0].equals("mum!")) {
				for (int j=0 ; j<table.size()/2 ; j++) {
					table.addLast(table.pollFirst());
				}
			} else {
				throw new IllegalArgumentException("invalid command!...");
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(table.size()).append("\n");
		while (!table.isEmpty()) {
			sb.append(table.pollFirst()).append(" ");
		}
		return sb.toString();
	}

}
