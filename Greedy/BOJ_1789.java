// BOJ - 1789
// Problem Sheet - https://www.acmicpc.net/problem/1789

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		long n = key.nextLong();
		int answer = 0;
		long decrement = 1;

		while(true) {
			if(n-decrement <= decrement) {
				answer++;
				break;
			}
			n -= decrement;
			decrement++;
			answer++;
		}

		System.out.println(answer);
		System.exit(0);
    }
}
