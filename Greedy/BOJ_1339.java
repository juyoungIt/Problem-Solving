// BOJ - 1339
// Problem Sheet - https://www.acmicpc.net/problem/1339

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int[] alpha = new int[26]; // 수집된 알파벳 정보를 저장

		int n = Integer.parseInt(bf.readLine()); // 문자열의 수
		String[] str = new String[n]; // 입력되는 문자열을 저장
		int answer = 0;
		int value = 9;
		
		// 문자열 입력
		for(int i=0 ; i<n ; i++)
			str[i] = bf.readLine();
		
		// 문자열을 구성하는 각 문자에 대한 정보를 수집함
		for(int i=0 ; i<n ; i++)
			for(int j=0 ; j<str[i].length() ; j++)
				alpha[str[i].charAt(j)-65] += (int)Math.pow(10, str[i].length()-j-1);

		// 수집된 정보를 기반으로 최대합을 도출함
		int idx = 0;
		while(!isFinish(alpha)) {
			idx = getBigIdx(alpha);
			answer += alpha[idx] * value;
			value--;
			alpha[idx] = 0;
		}

		System.out.println(answer);

		bf.close();
		System.exit(0);
    }

	// 모든 alpha에 대한 값이 처리되었는 지 확인함.
	public static boolean isFinish(int[] arr) {
		for(int i=0 ; i<arr.length ; i++)
			if(arr[i] > 0)
				return false;
		return true;
	}

	// 가장 큰 수의 인덱스를 구함
	public static int getBigIdx(int[] arr) {
		int max_val = 0;
		int max_idx = 0;
		
		for(int i=0 ; i<arr.length ; i++) {
			if(max_val < arr[i]) {
				max_val = arr[i];
				max_idx = i;
			}
		}
		return max_idx;
	}
}