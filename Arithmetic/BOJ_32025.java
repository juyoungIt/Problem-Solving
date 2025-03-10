// BOJ - 32025
// Problem Sheet - https://www.acmicpc.net/problem/32025

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int H = Integer.parseInt(br.readLine()) * 100;
		int W = Integer.parseInt(br.readLine()) * 100;
		System.out.println(Math.min(H / 2, W / 2));
		br.close();
	}
}
