// BOJ - 14783
// Problem Sheet - https://www.acmicpc.net/problem/14783

import java.util.*;
import java.io.*;

public class Main {

	private static int N, L;
	private static int[] removes;
	private static Queue<Integer> queue;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] row = br.readLine().split(" ");
		N = Integer.parseInt(row[0]);
		L = Integer.parseInt(row[1]);
		removes = new int[L];
		row = br.readLine().split(" ");
		for (int i=0 ; i<L ; i++) {
			removes[i] = Integer.parseInt(row[i]);
		}
		queue = new ArrayDeque<>();
		for (int i=1 ; i<=N ; i++) {
			queue.add(i);
		}
		br.close();
	}

	private static int solve() {
		int index = 0;
		while (queue.size() > 1) {
			for (int i=0 ; i<removes[index]-1 ; i++) {
				queue.add(queue.poll());
			}
			queue.poll();
			index = (index + 1) % L;
		}
		return queue.poll();
	}

}