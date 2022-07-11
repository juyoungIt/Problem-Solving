// BOJ - 1339
// Problem Sheet - https://www.acmicpc.net/problem/1339

import java.io.*;
import java.util.*;

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

		// test code - 1
		System.out.println("str = " + Arrays.toString(str));
		System.out.println("digit_info = " + Arrays.toString(digit_info));
		System.out.println("latest_idx = " + Arrays.toString(latest_idx));
		System.out.println("remain_nums = " + Arrays.toString(remain_nums));
		System.out.println("===================================================");
		
		int[][] ascii_info = new int[n][];
		for(int i=0 ; i<n ; i++) {
			ascii_info[i] = new int[str[i].length()];
			for(int j=0 ; j<str[i].length() ; j++)
				ascii_info[i][j] = (int)str[i].charAt(j) - 91;
		}

		// test code - 2
		for(int i=0 ; i<ascii_info.length ; i++)
			System.out.println("ascii_info = " + Arrays.toString(ascii_info[i]));
		System.out.println("===================================================");

		while(!isFinish(remain_nums)) {
			int max_idx = findBigDigit(digit_info, latest_idx, ascii_info);
			int code = ascii_info[max_idx][latest_idx[max_idx]];
			
			System.out.println("latest_idx = " + latest_idx[max_idx]);
			System.out.println("max_idx = " + max_idx);
			System.out.println("code = " + code);

			updateValue(code, value, ascii_info, remain_nums);
			updateDigitInfo(ascii_info, digit_info, latest_idx);
			
			System.out.println("value = " + value);
			value--;
			
			System.out.println("digit_info = " + Arrays.toString(digit_info));
			System.out.println("latest_idx = " + Arrays.toString(latest_idx));
			System.out.println("remain_nums = " + Arrays.toString(remain_nums));
			for(int i=0 ; i<ascii_info.length ; i++)
				System.out.println("ascii_info = " + Arrays.toString(ascii_info[i]));
			System.out.println("===================================================");
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

	public static int findBigDigit(int[] digit_info, int[] latest_idx, int[][] ascii_info) {
		int max_val = 0;
		int max_idx = 0;

		for(int i=0 ; i<digit_info.length ; i++) {
			if(digit_info[i] > max_val) {
				max_val = digit_info[i];
				max_idx = i;
			}
		}

		for(int i=0 ; i<ascii_info[max_idx].length ; i++) {
			if(ascii_info[max_idx][i] < 0) {
				latest_idx[max_idx] = i;
				break;
			}
		}

		return max_idx;
	}

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

	public static void updateDigitInfo(int[][] ascii_info, int[] digit_info, int[] latest_idx) {
		for(int i=0 ; i<ascii_info.length ; i++) {
			for(int j=0 ; j<ascii_info[i].length ; j++) {
				if(ascii_info[i][j] < 0) {
					digit_info[i] = ascii_info[i].length - j - 1;
					latest_idx[i] = j;
					break;
				}
			}
		}
	}

	public static int getSum(int[][] ascii_info) {
		int sum = 0;
		for(int i=0 ; i<ascii_info.length ; i++)
			for(int j=0 ; j<ascii_info[i].length ; j++) {
				sum += (int)Math.pow(10, (ascii_info[i].length-1)-j) * ascii_info[i][j];
				System.out.println("value = " + (int)Math.pow(10, (ascii_info[i].length-1)-j) * ascii_info[i][j]);
			}

		return sum;
	}
}
