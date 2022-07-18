// BOJ - 16953
// Problem Sheet - https://www.acmicpc.net/problem/16953

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		int answer = 1;

		while(a < b) {
			if((b-1)%10 == 0) {
				b = (b-1)/10;
				answer++;
			}
			else {
				if(b%2 != 0) {
					answer = -1;
					break;
				}
				b /= 2;
				answer++;
			}
		}

		if(a != b) answer = -1;

		System.out.println(answer);

		bf.close();
		System.exit(0);
	}
}