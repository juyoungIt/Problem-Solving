// BOJ - 12865
// Problem Sheet - https://www.acmicpc.net/problem/12865

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] row = br.readLine().split(" ");
		int N = Integer.parseInt(row[0]);
		int K = Integer.parseInt(row[1]);
		int[] storage = new int[K + 1];
		for (int i=0 ; i<N ; i++) {
			row = br.readLine().split(" ");
			int W = Integer.parseInt(row[0]);
			int V = Integer.parseInt(row[1]);
			for (int j=K ; j>=W ; j--) {
				storage[j] = Math.max(storage[j], storage[j - W] + V);
			}
		}

		System.out.println(storage[K]);
		br.close();
    }
}
