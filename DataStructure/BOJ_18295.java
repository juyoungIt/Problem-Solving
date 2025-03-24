// BOJ - 18295
// Problem Sheet - https://www.acmicpc.net/problem/18295

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] isExist = new boolean[N + 1];
		for (int i=0 ; i<N ; i++) {
			String ant = br.readLine();
			if (ant.charAt(0) == '-' || ant.length() > Integer.toString(N).length() || Integer.parseInt(ant) > N) {
				continue;
			}
			isExist[Integer.parseInt(ant)] = true;
		}
		for (int i=0 ; i<=N ; i++) {
			if (!isExist[i]) {
				System.out.println(i);
				break;
			}
		}
		br.close();
	}
}
