// BOJ - 14455
// Problem Sheet - https://www.acmicpc.net/problem/14455

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

	private static final Map<String, Integer> milks = new HashMap<>();
	private static final String[] cows = { "Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta" };
	private static final String TIE = "Tie";

	public static void main(String[] args) throws IOException {
		init();
		input();
		System.out.println(solve());
	}

	private static void init() {
		for (String cow : cows) {
			milks.put(cow, 0);
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i=0 ; i<N ; i++) {
			String[] row = br.readLine().split(" ");
			milks.put(row[0], milks.get(row[0]) + Integer.parseInt(row[1]));
		}
		br.close();
	}

	private static String solve() {
		Map<Integer, List<String>> report = new HashMap<>();
		for (Map.Entry<String, Integer> entry : milks.entrySet()) {
			if (!report.containsKey(entry.getValue())) {
				report.put(entry.getValue(), new ArrayList<>());
			}
			report.get(entry.getValue()).add(entry.getKey());
		}
		List<Map.Entry<Integer, List<String>>> result = report.entrySet().stream()
				.sorted(Comparator.comparingInt(Map.Entry::getKey))
				.collect(Collectors.toList());
		return result.size() < 2 || result.get(1).getValue().size() > 1
				? TIE
				: result.get(1).getValue().get(0);
	}

}
