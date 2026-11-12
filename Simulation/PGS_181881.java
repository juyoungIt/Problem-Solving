// PGS - 181881
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181881

import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int len = arr.length;
        int[] before = new int[len];
        while (!Arrays.equals(arr, before)) {
            System.arraycopy(arr, 0, before, 0, len);
            for (int i=0; i<len; i++) {
                if (arr[i] >= 50 && arr[i] % 2 == 0) {
                    arr[i] /= 2;
                } else if (arr[i] < 50 && arr[i] % 2 != 0) {
                    arr[i] *= 2;
                    arr[i]++;
                }
            }
            answer++;
        }
        return answer - 1;
    }
}
