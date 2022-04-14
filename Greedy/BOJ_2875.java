// BOJ - 2875
// Problem Sheet - https://www.acmicpc.net/problem/2875

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int n = key.nextInt(); // the number of woman
		int m = key.nextInt(); // the number of man
		int k = key.nextInt(); // internship
		int team; // the maximum number of team

		team = (2*m > n) ? n/2 : m;	
		k -= ((m+n) - team*3);
		
		while(true) {
			if(k <= 0) break;
			else {
				team--;
				k -= 3;
			}
		}

		System.out.println(team);
		
		key.close();
		System.exit(0);
	}
}
