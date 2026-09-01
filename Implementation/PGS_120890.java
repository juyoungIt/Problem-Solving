// PGS - 120890
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120890

import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        Arrays.sort(array);
        int left, right;
        int len = array.length;
        for (left=0; left<len; left++) {
            if (array[left] >= n) break;
        }
        left = Math.min(left, len - 1);
        for (right=len-1; right>=0; right--) {
            if (array[right] <= n) break;
        }
        right = Math.max(0, right);
        if (Math.abs(array[left] - n) == Math.abs(array[right] - n)) {
            return array[Math.min(left, right)];
        } else if (Math.abs(array[left] - n) < Math.abs(array[right] - n)) {
            return array[left];
        } else {
            return array[right];
        }
    }
}
