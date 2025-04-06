// BOJ - 24793
// Problem Sheet - https://www.acmicpc.net/problem/24793

import java.util.*;
import java.io.*;

public class Main {

	private static int n;
	private static String[] h;
	private static final String FAIR = "Fair Game";
	private static final String NOT_FAIR = "Player %d lost";

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		h = new String[n];
		for (int i=0 ; i<n ; i++) {
			h[i] = br.readLine();
		}
		br.close();
	}

	private static String solve() {
		Set<String> ws = new HashSet<>();
		for (int i=0 ; i<n ; i++) {
			if (i > 0 && (ws.contains(h[i]) || !isValid(h[i - 1], h[i]))) {
				return String.format(NOT_FAIR, i % 2 == 0 ? 1 : 2);
			}
			ws.add(h[i]);
		}
		return FAIR;
	}

	private static boolean isValid(String prev, String next) {
		return prev.charAt(prev.length() - 1) == next.charAt(0);
	}
}
