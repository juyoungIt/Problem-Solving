// BOJ - 2864
// Problem Sheet - https://www.acmicpc.net/problem/2864

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		String[] input = new String[2];
		input[0] = st.nextToken();
		input[1] = st.nextToken();
		int min = 0, max = 0; // store the min, max value of sum
		
		for(String str : input) {
			str = str.replace("6", "5");
			min += Integer.parseInt(str);
		}

		for(String str : input) {
			str = str.replace("5", "6");
			max += Integer.parseInt(str);
		}

		System.out.println(min + " " + max);

		bf.close();
		System.exit(0);
	}
}