// BOJ - 4126
// Problem Sheet - https://www.acmicpc.net/problem/4126

import java.util.*;
import java.io.*;

public class Main {

	private static int n;
	private static String[] logs;
	
	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		logs = new String[n];
		for (int i=0 ; i<n ; i++) {
			logs[i] = br.readLine();
		}
		br.close();
	}

	private static String solve() {
		Map<String, Set<String>> requests = new HashMap<>();
		for (String log : logs) {
			String[] tokens = log.split(" ");
			String name = tokens[0] + " " + tokens[1];
			String lecture = tokens[2];
			if (!requests.containsKey(name)) requests.put(name, new HashSet<>());
			requests.get(name).add(lecture);
		}
		
		Map<String, Integer> counts = new HashMap<>();
		for (Set<String> lectures : requests.values()) {
			for (String lecture : lectures) {
				counts.put(lecture, counts.getOrDefault(lecture, 0) + 1);
			}
		}

		StringBuilder sb = new StringBuilder();
		counts.entrySet().stream()
			.sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
			.forEach(e -> sb.append(e.getKey()).append(" ").append(e.getValue()).append("\n"));
		return sb.toString();
	}

}
