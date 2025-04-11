// BOJ - 15832
// Problem Sheet - https://www.acmicpc.net/problem/15832

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String[] row = br.readLine().split(" ");
			int n = Integer.parseInt(row[0]);
			int m = Integer.parseInt(row[1]);
			if (n == 0 && m == 0) break;
			Queue<Integer> queue = new ArrayDeque<>();
			for (int i=1 ; i<=n ; i++) queue.add(i);
			while (queue.size() > 1) {
				for (int i=0 ; i<m-1 ; i++) queue.add(queue.poll());
				queue.poll();
			}
			sb.append(queue.poll()).append("\n");
		}

		System.out.println(sb);
		br.close();
	}

}
