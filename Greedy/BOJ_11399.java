// BOJ - 11399
// Problem Sheet - https://www.acmicpc.net/problem/11399

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		
		// enter the user input
		Scanner key = new Scanner(System.in);
		int p_num = key.nextInt(); // waiting people
		int[] timeCost = new int[p_num]; // time cost of each people
		for(int i=0 ; i<p_num ; i++)
			timeCost[i] = key.nextInt();
		int minCost = 0; // the minimum cost

		// sort the time cost of each people
		Arrays.sort(timeCost);
		for(int i=0 ; i<p_num ; i++)
			minCost += getAccumCost(timeCost, p_num-i);

		System.out.println(minCost);

		key.close(); // close the scanner
		System.exit(0);
	}

	public static int getAccumCost(int[] arr, int len) {
		if(len == 1)
			return arr[len-1];
		else
			return arr[len-1] + getAccumCost(arr, len-1);
	}
}
