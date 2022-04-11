// BOJ - 2231
// Problem Sheet - https://www.acmicpc.net/problem/2231

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int n = key.nextInt(); // natural number 'n'
		int tmp, dec;
		int result = 0;

		// search the constructor
		for(int i=1 ; i<=n ; i++) {
			dec = i;
			tmp = i;
			while(tmp/10 != 0) {
				dec += tmp%10;
				tmp /= 10;
			}
			dec += tmp%10;

			if(dec == n) {
				result = i;
				break;
			}
		}

		System.out.println(result);
		key.close();
		System.exit(0);
	}
}
