// BOJ - 2839
// Problem Sheet - https://www.acmicpc.net/problem/2839

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int n = key.nextInt();
		int result = 0;

		while(true) {
			if(n < 0) {
				result = -1;
				break;
			}
			if(n == 0)
				break;
			else {
				if(n%5 == 0) {
					result += n/5;
					break;
				}
				else {
					n -= 3;
					result++;
				}
			}
		}

		System.out.println(result);

		key.close();
		System.exit(0);
	}
}
