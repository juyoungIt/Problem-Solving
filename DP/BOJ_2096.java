// BOJ - 2096
// Problem Sheet - https://www.acmicpc.net/problem/2096

import java.util.*;
import java.io.*;

public class Main {

	private static int N;
	private static int[][] b;
	private static int[] dmx, dmn;
	private static int[] tmx, tmn; // 임시저장 용도

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		b = new int[N][5];
		for (int i=0 ; i<N ; i++) {
			String[] row = br.readLine().split(" ");
			for (int j=1 ; j<=3 ; j++) {
				b[i][j] = Integer.parseInt(row[j - 1]);
			}
		}
		dmx = new int[5];
		dmn = new int[5];
		tmx = new int[5];
		tmn = new int[5];
		Arrays.fill(dmn, 900_001);
		br.close();
	}

	private static String solve() {
		for (int i=1 ; i<=3 ; i++) {
			dmx[i] = dmn[i] = b[0][i];
		}
		for (int i=1 ; i<N ; i++) {
			for (int j=1 ; j<=3 ; j++) {
				tmx[j] = b[i][j] + Math.max(dmx[j - 1], Math.max(dmx[j], dmx[j + 1]));
				tmn[j] = b[i][j] + Math.min(dmn[j - 1], Math.min(dmn[j], dmn[j + 1]));
			}
			for (int j=1 ; j<=3 ; j++) {
				dmx[j] = tmx[j];
				dmn[j] = tmn[j];
			}
		}
		int max = Math.max(dmx[1], Math.max(dmx[2], dmx[3]));
		int min = Math.min(dmn[1], Math.min(dmn[2], dmn[3]));
		return max + " " + min;
	}

}