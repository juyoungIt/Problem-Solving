// BOJ - 29645
// Problem Sheet - https://www.acmicpc.net/problem/29645

import java.util.*;
import java.io.*;

public class Main {

	static class Country implements Comparable<Country> {
		private String name;
		private int g;
		private int s;
		private int b;

		public Country(String name) {
			this.name = name;
		}

		public String getName() { return this.name; }
		public int getG() { return this.g; }
		public int getS() { return this.s; }
		public int getB() { return this.b; }
		public void addG() { this.g++; }
		public void addS() { this.s++; }
		public void addB() { this.b++; }

		@Override
		public int compareTo(Country c) {
			if (this.g == c.getG()) {
				if (this.s == c.getS()) {
					if (this.b == c.getB()) {
						return this.name.compareTo(c.getName());
					}
					return c.getB() - this.b;
				}
				return c.getS() - this.s;
			}
			return c.getG() - this.g;
		}
	}

	private static int n;
	private static String[][] h;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		h = new String[n][3];
		for (int i=0 ; i<n ; i++) {
			String[] row = br.readLine().split(" ");
			h[i][0] = row[0];
			h[i][1] = row[1];
			h[i][2] = row[2];
		}
		br.close();
	}

	private static String solve() {
		Map<String, Country> countryMap = new HashMap<>();
		PriorityQueue<Country> pQueue = new PriorityQueue<>();
		for (String[] m : h) {
			for (int i=0 ; i<3 ; i++) {
				if (!countryMap.containsKey(m[i])) {
					countryMap.put(m[i], new Country(m[i]));
				}
				if (i == 0) countryMap.get(m[i]).addG();
				else if (i == 1) countryMap.get(m[i]).addS();
				else countryMap.get(m[i]).addB();
			}
		}
		countryMap.values().stream().forEach(pQueue::add);
		return pQueue.peek().getName();
	}

}
