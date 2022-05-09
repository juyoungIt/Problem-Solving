// BOJ - 10162
// Problem Sheet - https://www.acmicpc.net/problem/10162

import java.util.Scanner;

public class Main {

	final static int timeA = 300; // buttonA preset
	final static int timeB = 60;  // buttonB preset
	final static int timeC = 10;  // buttonC preset

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int t = key.nextInt(); // cooking time
		int[] counts = new int[3]; // click count of each buttons
		boolean result = true;    // is the result exist?
		
		if(t%10 != 0)
			result = false;
		else {
			counts[0] = t/timeA;
			counts[1] = (t%timeA) / timeB;
			counts[2] = ((t%timeA) % timeB) / timeC;
		}

		if(result) {
			for(int count : counts)
				System.out.print(count + " ");
			System.out.println();
		}
		else
			System.out.println("-1");

		key.close();
		System.exit(0);
	}
}
