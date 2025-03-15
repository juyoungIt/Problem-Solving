// BOJ - 2624
// Problem Sheet - https://www.acmicpc.net/problem/2624

import java.util.*;
import java.io.*;

public class Main {

	private static int T, k;
	private static int[][] coins;
	private static int[] storage;

    public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
    }

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		storage = new int[T + 1];
		coins = new int[k][2];
		for (int i=0 ; i<k ; i++) {
			String[] row = br.readLine().split(" ");
			int pi = Integer.parseInt(row[0]);
			int ni = Integer.parseInt(row[1]);
			coins[i][0] = pi;
			coins[i][1] = ni;
		}
		br.close();
	}
	
	private static int solve() {
		storage[0] = 1;
		for (int i=0 ; i<k ; i++) {
			int price = coins[i][0];
			int count = coins[i][1];
			for (int j=T ; j>=0 ; j--) {
				for (int k=1 ; k<=count ; k++) {
					int nextPrice = j + price * k;
					if (nextPrice > T) break;
					storage[nextPrice] += storage[j];
				}
			}
		}
		return storage[T];
	}
}
