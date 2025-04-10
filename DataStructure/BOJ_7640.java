// BOJ - 7640
// Problem Sheet - https://www.acmicpc.net/problem/7640

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			int[] h = new int[n];
			for (int i=0 ; i<n ; i++) {
				h[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(h);
			PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
			for (int i=n-1 ; i>=0 ; i--) {
				if (!pQueue.isEmpty() && pQueue.peek() > h[i]) pQueue.poll();
				pQueue.add(h[i]);
			}
			sb.append(pQueue.size()).append("\n");
		}

		System.out.println(sb);
		br.close();
	}
}
