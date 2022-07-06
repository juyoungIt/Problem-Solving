// BOJ - 13305
// Problem Sheet - https://www.acmicpc.net/problem/13305

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int n = key.nextInt();
		long[] dist = new long[n-1];
		long[] price = new long[n];

		for(int i=0 ; i<n-1 ; i++)
			dist[i] = key.nextLong();
		for(int i=0 ; i<n ; i++)
			price[i] = key.nextLong();

		long min_price = price[0];
		long answer = dist[0] * price[0];
		for(int i=1 ; i<n-1 ; i++) {
			if(min_price > price[i])
				min_price = price[i];
			answer += (dist[i] * min_price);
		}

		System.out.println(answer);
		System.exit(0);
    }
}
