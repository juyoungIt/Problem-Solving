// BOJ - 30949
// Problem Sheet - https://www.acmicpc.net/problem/30949

import java.util.*;
import java.io.*;

public class Main {

	private static final String FIRST_LINE = "------";
	private static final String SECOND_LINE = "======";
	private static final String NO_DIFFERENCES = "No differences found.";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<String, Integer> times = new HashMap<>();
		
		while (true) {
			String[] row = br.readLine().split(" ");
			if (row[0].equals(FIRST_LINE)) break;
			int s = Integer.parseInt(row[0]);
			int e = Integer.parseInt(row[1]);
			String t = row[2];
			times.put(t, times.getOrDefault(t, 0) - (e - s));
		}

		while (true) {
			String[] row = br.readLine().split(" ");
			if (row[0].equals(SECOND_LINE)) break;
			int s = Integer.parseInt(row[0]);
			int e = Integer.parseInt(row[1]);
			String t = row[2];
			times.put(t, times.getOrDefault(t, 0) + (e - s));
		}

		times.entrySet().stream()
			.sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
			.filter(e -> e.getValue() != 0)
			.forEach(e -> sb.append(String.format("%s %+d\n", e.getKey(), e.getValue())));
		System.out.println(sb.length() == 0 ? NO_DIFFERENCES : sb);
		br.close();
	}

}
