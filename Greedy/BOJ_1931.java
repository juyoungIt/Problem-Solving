// BOJ - 1931
// Problem Sheet - https://www.acmicpc.net/problem/1931

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int size = key.nextInt(); // the number of conference
		int[][] confList = new int[size][2];
		for(int i=0 ; i<size ; i++) {
			confList[i][0] = key.nextInt();
			confList[i][1] = key.nextInt();
		}
		int maxCount = 0;     // the maximum number of conference
		int lastEndTime = 0;  // store the last end time of conference (latest)

		// sort by using end time
		Arrays.sort(confList, new Comparator<int[]>() {
			@Override
			public int compare(int[] ae1, int[] ae2) {
				if(ae1[1] == ae2[1])
					return ae1[0] - ae2[0];
				else
					return ae1[1] - ae2[1];
			}
		});

		// find best solution
		for(int i=0 ; i<size ; i++) {
			if(lastEndTime <= confList[i][0]) {
				lastEndTime = confList[i][1];
				maxCount++;
			}
		}

		System.out.println(maxCount);

		key.close();
		System.exit(0);
	}
}
