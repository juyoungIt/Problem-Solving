// BOJ - 4992
// Problem Sheet - https://www.acmicpc.net/problem/4992

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String[] row = br.readLine().split(" ");
			int n = Integer.parseInt(row[0]);
			int r = Integer.parseInt(row[1]);
			if (n == 0 && r == 0) break;
			Deque<Integer> stack = new ArrayDeque<>(n);
			Deque<Integer> top = new ArrayDeque<>(n);
			Deque<Integer> tmp = new ArrayDeque<>(n);
			for (int i=1 ; i<=n ; i++) stack.push(i);
			for (int i=0 ; i<r ; i++) {
				row = br.readLine().split(" ");
				int p = Integer.parseInt(row[0]);
				int c = Integer.parseInt(row[1]);
				for (int j=0 ; j<p-1 ; j++) top.push(stack.pop());
				for (int j=0 ; j<c ; j++) tmp.push(stack.pop());
				for (int j=0 ; j<p-1 ; j++) stack.push(top.pop());
				for (int j=0 ; j<c ; j++) stack.push(tmp.pop());
			}
			sb.append(stack.peek()).append("\n");
		}

		System.out.println(sb);
		br.close();
	}
}
