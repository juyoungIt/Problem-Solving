// BOJ - 1339
// Problem Sheet - https://www.acmicpc.net/problem/1339

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		String[] str = new String[n];
		int[] digit_info = new int[n];
		int[] latest_idx = new int[n];
		int[] remain_nums = new int[n];
		int value = 9;

		for(int i=0 ; i<n ; i++) {
			str[i] = bf.readLine();
			digit_info[i] = str[i].length();
			latest_idx[i] = 0;
			remain_nums[i] = str[i].length();
		}
		
		int[][] ascii_info = new int[n][];
		for(int i=0 ; i<n ; i++) {
			ascii_info[i] = new int[str[i].length()];
			for(int j=0 ; j<str[i].length() ; j++)
				ascii_info[i][j] = (int)str[i].charAt(j) - 91;
		}

		while(!isFinish(remain_nums)) {
			int max_idx = findBigDigit(digit_info, latest_idx, remain_nums, ascii_info);
			int code = ascii_info[max_idx][latest_idx[max_idx]];

			updateValue(code, value, ascii_info, remain_nums);
			updateDigitInfo(ascii_info, digit_info, latest_idx);
			
			value--;
		}

		System.out.println(getSum(ascii_info));

		bf.close();
		System.exit(0);
    }

	public static boolean isFinish(int[] remain_nums) {
		for(int i=0 ; i<remain_nums.length ; i++)
			if(remain_nums[i] > 0)
				return false;
		return true;
	}

	// 제시된 문자열 중에서 가장 큰 자릿수를 찾음
	public static int findBigDigit(int[] digit_info, int[] latest_idx, int[] remain_nums, int[][] ascii_info) {
		int max_val = 0; // 최댓값
		int max_idx = 0; // 최댓의 index

		// 가장 큰 단위의 자릿수를 가지는 문자열의 index 값을 구함
		for(int i=0 ; i<digit_info.length ; i++) {
			if(digit_info[i] > max_val && remain_nums[i] > 0) {
				max_val = digit_info[i];
				max_idx = i;
			}
		}

		return max_idx;
	}

	// 특정 알파벳에 대해서 Mapping된 값으로 모두 업데이트
	public static void updateValue(int code, int value, int[][] ascii_info, int[] remain_nums) {
		for(int i=0 ; i<ascii_info.length ; i++) {
			for(int j=0 ; j<ascii_info[i].length ; j++) {
				if(ascii_info[i][j] == code) {
					ascii_info[i][j] = value;
					remain_nums[i]--;
				}
			}
		}
	}

	// 주입된 값에 맞춰 자릿수에 대한 정보를 최신화함
	public static void updateDigitInfo(int[][] ascii_info, int[] digit_info, int[] latest_idx) {
		for(int i=0 ; i<ascii_info.length ; i++) {
			for(int j=0 ; j<ascii_info[i].length ; j++) {
				if(ascii_info[i][j] < 0) {
					digit_info[i] = ascii_info[i].length - j;
					latest_idx[i] = j;
					break;
				}
			}
		}
	}

	// 최종 합산값을 구함
	public static int getSum(int[][] ascii_info) {
		int sum = 0;
		for(int i=0 ; i<ascii_info.length ; i++)
			for(int j=0 ; j<ascii_info[i].length ; j++)
				sum += (int)Math.pow(10, (ascii_info[i].length-1)-j) * ascii_info[i][j];
		return sum;
	}
}