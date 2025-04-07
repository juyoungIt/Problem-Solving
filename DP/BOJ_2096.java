// BOJ - 2096
// Problem Sheet - https://www.acmicpc.net/problem/2096

import java.util.*;
import java.io.*;

public class Main {

	private static final int IMPOSSIBLE = 1_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dmx = new int[5];
		int[] dmn = new int[5];
		dmn[0] = dmn[4] = IMPOSSIBLE;
		int[] tmx = new int[5]; 
		int[] tmn = new int[5];
		tmn[0] = tmn[4] = IMPOSSIBLE;
		int n = Integer.parseInt(br.readLine());
		for (int i=0 ; i<n ; i++) {
			String[] row = br.readLine().split(" ");
			for (int j=1 ; j<=3 ; j++) {
				int value = Integer.parseInt(row[j - 1]);
				tmx[j] = value + Math.max(dmx[j - 1], Math.max(dmx[j], dmx[j + 1]));
				tmn[j] = value + Math.min(dmn[j - 1], Math.min(dmn[j], dmn[j + 1]));
			}
			System.arraycopy(tmx, 0, dmx, 0, 5);
			System.arraycopy(tmn, 0, dmn, 0, 5);
		}
		int max = Math.max(dmx[1], Math.max(dmx[2], dmx[3]));
		int min = Math.min(dmn[1], Math.min(dmn[2], dmn[3]));
		System.out.printf("%d %d\n", max, min);
		br.close();
	}
}