// BOJ - 4368
// Problem Sheet - https://www.acmicpc.net/problem/4368

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Map<String, String> dict = new HashMap<>();
		while (true) {
			String[] input = br.readLine().split(" ");
			if (input[0].length() == 0) break;
			dict.put(input[1], input[0]);
		}

		while (true) {
			String query = br.readLine();
			if (query == null) break;
			sb.append(dict.getOrDefault(query, "eh")).append("\n");
		}

		System.out.println(sb);
		br.close();
	}
}
