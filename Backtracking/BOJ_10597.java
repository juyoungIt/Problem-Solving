// BOJ - 10597
// Problem Sheet - https://www.acmicpc.net/problem/10597

import java.io.*;

public class Main {

	private static String str;
	private static int N;
	private static boolean[] isUsed;
	private static int[] elements;

    public static void main(String[] args) throws IOException {
		input();
		solve(0, 0);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		N = getN(str.length());
		isUsed = new boolean[N + 1];
		elements = new int[N];
		br.close();
	}

	private static void solve(int index, int count) {
		if (index >= str.length()) {
			for (int element : elements) {
				System.out.print(element + " ");
			}
			System.exit(0);
		}
		int element = getValue(index, 1);
		if (!isUsed[element]) {
			isUsed[element] = true;
			elements[count] = element;
			solve(index + 1, count + 1);
			isUsed[element] = false;
		}
		if (index + 1 >= str.length()) return;
		element = getValue(index, 2);
		if (element <= N && !isUsed[element]) {
			isUsed[element] = true;
			elements[count] = element;
			solve(index + 2, count + 1);
			isUsed[element] = false;
		}
	}

	private static int getN(int len) {
		return len < 10 ? len : 9 + (len - 9) / 2;
	}

	private static int getValue(int index, int length) {
		int value = 0;
		for (int i=index ; i<index + length ; i++) {
			value *= 10;
			value += str.charAt(i) - '0';
		}
		return value;
	}
}