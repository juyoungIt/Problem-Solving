// PGS - 181856
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181856

import java.util.*;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        // 1. 배열의 길이를 기준으로 판별
        if (len1 < len2) {
            return -1;
        } else if (len1 > len2) {
            return 1;
        } else {
            // 2. 배열 원소의 합을 기준으로 판별
            int sum1 = Arrays.stream(arr1).sum();
            int sum2 = Arrays.stream(arr2).sum();
            if (sum1 == sum2) return 0;
            else if (sum1 > sum2) return 1;
            else return -1;
        }
    }
}
