// BOJ - 1253
// Problem Sheet - https://www.acmicpc.net/problem/1253

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int goodCnt = 0;
        for(int i=0 ; i<n ; i++) {
            if(isGoodNumber(nums, i)) {
                goodCnt++;
            }
        }
        System.out.println(goodCnt);

        bf.close();
        System.exit(0);
    }

    private static boolean isGoodNumber(int[] nums, int targetIdx) {
        int left = 0, right = nums.length-1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(left == targetIdx) {
                left++;
                continue;
            }
            if(right == targetIdx) {
                right--;
                continue;
            }
            if(sum == nums[targetIdx]) {
                return true;
            }
            if(sum < nums[targetIdx]) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}