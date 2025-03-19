// BOJ - 32386
// Problem Sheet - https://www.acmicpc.net/problem/32386

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> tagCount = new HashMap<>();
		while (N-- > 0) {
			String[] row = br.readLine().split(" ");
			int s = Integer.parseInt(row[0]);
			int t = Integer.parseInt(row[1]);
			for (int i=2 ; i<t+2 ; i++) {
				tagCount.put(row[i], tagCount.getOrDefault(row[i], 0) + 1);
			}
		}

		List<Map.Entry<String, Integer>> tags = tagCount.entrySet().stream()
				.sorted((t1, t2) -> t2.getValue() - t1.getValue())
				.collect(Collectors.toList());

		if (tags.size() >= 2 && tags.get(0).getValue().intValue() == tags.get(1).getValue().intValue()) {
			System.out.println(-1);
		} else {
			System.out.println(tags.get(0).getKey());
		}
		br.close();
	}
}
