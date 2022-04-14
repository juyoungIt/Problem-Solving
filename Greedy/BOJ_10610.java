// BOJ - 10610
// Problem Sheet - https://www.acmicpc.net/problem/10610

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		String input = key.nextLine(); // input number
		int[] digitCount = new int[10]; // store the number of each numbers (0 ~ 9)
		int sum = 0;
		String result; // store the result value
		StringBuilder sb = new StringBuilder();

		// parse the each digit
		for(int i=0 ; i<input.length() ; i++) {
			int index = Integer.parseInt(input.charAt(i) + "");
			digitCount[index]++;
			sum += index;
		}

		// validation
		if(!input.contains("0") || sum%3 != 0)
			result = "-1";
		else {
			for(int i=9 ; i>=0 ; i--) {
				while(digitCount[i] > 0) {
					sb.append(i);
					digitCount[i]--;
				}
			}
			result = sb.toString();
		}

		System.out.println(result);

		key.close();
		System.exit(0);
	}
}
