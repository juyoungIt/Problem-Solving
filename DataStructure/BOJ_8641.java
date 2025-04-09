// BOJ - 8641
// Problem Sheet - https://www.acmicpc.net/problem/8641

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		Map<Integer, Integer> p = new LinkedHashMap<>();
		for (int i=0 ; i<n ; i++) {
			String[] row = br.readLine().split(" ");
			int a = Integer.parseInt(row[0]);
			int k = Integer.parseInt(row[1]);
			p.put(a, p.getOrDefault(a, 0) + k);
		}

		sb.append(p.size()).append("\n");
		for (Map.Entry<Integer, Integer> entry : p.entrySet()) {
			sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
		}
		System.out.println(sb);
		br.close();

	}
}
