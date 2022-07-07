// BOJ - 1946
// Problem Sheet - https://www.acmicpc.net/problem/1946

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc_count = Integer.parseInt(bf.readLine());
		int[] answer = new int[tc_count];
		int applicants;
		int idx, value;

		for(int i=0 ; i<tc_count ; i++){
			applicants = Integer.parseInt(bf.readLine());
			int min = applicants;
			int count = 0;
			int[] tc = new int[applicants+1];
			for(int j=0 ; j<applicants ; j++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				idx = Integer.parseInt(st.nextToken());
				value = Integer.parseInt(st.nextToken());
				tc[idx] = value;
			}

			for(int j=1 ; j<=applicants ; j++) {
				if(tc[j] <= min) {
					min = tc[j];
					count++;
				}
			}
			answer[i] = count;
		}

		for(int i=0 ; i<tc_count ; i++)
			System.out.println(answer[i]);
		
		bf.close();
		System.exit(0);
    }
}