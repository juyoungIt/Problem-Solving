// BOJ - 13915
// Problem Sheet - https://www.acmicpc.net/problem/13915

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String input = br.readLine();
			if (input == null) break;
			int n = Integer.parseInt(input);
			Set<Set<Integer>> groups = new HashSet<>();
			for (int i=0 ; i<n ; i++) {
				String flights = br.readLine();
				Set<Integer> group = new HashSet<>();
				for (int j=0 ; j<flights.length() ; j++) {
					group.add(flights.charAt(j) - '0');
				}
				groups.add(group);
			}
			sb.append(groups.size()).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
