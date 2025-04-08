// BOJ - 5104
// Problem Sheet - https://www.acmicpc.net/problem/5104

import java.util.*;
import java.io.*;

public class Main {
	
	private static final String OUTPUT_FORMAT = "Week %d %s";
	private static final String EMPTY = "No phones confiscated";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Map<String, Integer> penalties = new HashMap<>();
		penalties.put("TT", 75);
		penalties.put("TX", 50);
		penalties.put("PR", 80);
		penalties.put("RT", 30);
		penalties.put("AP", 25);
		penalties.put("PX", 60);

		while (true) {
			String[] row = br.readLine().split(" ");
			int w = Integer.parseInt(row[0]);
			int n = Integer.parseInt(row[1]);
			if (w == 0 && n == 0) break;
			Map<String, Integer> demerits = new LinkedHashMap<>();
			for (int i=0 ; i<n ; i++) {
				row = br.readLine().split(" ");
				String name = row[0];
				String action = row[1];
				demerits.put(name, demerits.getOrDefault(name, 0) + penalties.get(action));
			}
			StringJoiner sj = new StringJoiner(",");
			for (Map.Entry<String, Integer> entry : demerits.entrySet()) {
				if (entry.getValue() >= 100) {
					sj.add(entry.getKey());
				}
			}
			sb.append(String.format(OUTPUT_FORMAT, w, sj.length() > 0 ? sj.toString() : EMPTY)).append("\n");
		}

		System.out.println(sb);
		br.close();
	}
}
