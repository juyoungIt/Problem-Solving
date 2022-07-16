// BOJ - 1439
// Problem Sheet - https://www.acmicpc.net/problem/1439

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String str = bf.readLine();
		int[] groupCount = new int[2];
		char curVal;

		curVal = str.charAt(0);
		for(int i=0 ; i<str.length() ; i++) {
			if(curVal != str.charAt(i)) {
				groupCount[Integer.parseInt(curVal+"")]++;
				curVal = str.charAt(i);
			}
		}
		groupCount[Integer.parseInt(curVal+"")]++;

		System.out.println(Math.min(groupCount[0], groupCount[1]));

		bf.close();
		System.exit(0);
	}
}