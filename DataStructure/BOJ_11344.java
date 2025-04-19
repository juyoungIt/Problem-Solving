// BOJ - 11344
// Problem Sheet - https://www.acmicpc.net/problem/11344

import java.util.*;
import java.io.*;

public class Main {

	static class Student {
		private final String name;
		private final int money;

		public Student(String name, int money) {
			this.name = name;
			this.money = money;
		}

		public String getName() { return this.name; }
		public int getMoney() { return this.money; }
	}

	private static final String EMPTY = "Line B stayed empty.";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			br.readLine(); // read empty line
			int n = Integer.parseInt(br.readLine());
			Deque<Student> lineA = new ArrayDeque<>(n);
			Deque<Student> lineB = new ArrayDeque<>(n);
			for (int i=0 ; i<n ; i++) {
				String[] row = br.readLine().split(" ");
				String name = row[0];
				int money = Integer.parseInt(row[1]);
				lineA.addLast(new Student(name, money));
			}
			int maxQueue = 0;
			int change = 0;
			StringJoiner sj = new StringJoiner(" ");
			while (!lineA.isEmpty() || (!lineB.isEmpty() && change >= 5)) {
				if (!lineB.isEmpty() && change >= 5) {
					lineB.pollFirst();
					change -= 5;
				} else if (lineA.peekFirst().getMoney() == 15) {
					lineA.pollFirst();
					change += 5;
				} else {
					if (change >= 5) {
						lineA.pollFirst();
						change -= 5;
					} else {
						lineB.addLast(lineA.pollFirst());
						if (maxQueue < lineB.size()) {
							maxQueue = lineB.size();
							sj = new StringJoiner(" ");
							for (Student s : lineB) {
								sj.add(s.getName());
							}
						}
					}
				}
			}
			sb.append(maxQueue == 0 ? EMPTY : sj.toString()).append("\n");
		}

		System.out.println(sb);
		br.close();
	}
}
