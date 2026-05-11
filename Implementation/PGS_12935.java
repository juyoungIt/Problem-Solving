// PGS - 12935
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/12935

import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int n = arr.length;
        int min = arr[0];
        if (n == 1) {
            int[] answer = { -1 };
            return answer;
        }
        int[] answer = new int[n - 1];
        for (int i=0 ; i<n ; i++) {
            min = Math.min(min, arr[i]);
        }
        int curIdx = 0;
        for (int i=0 ; i<n ; i++) {
            if (arr[i] == min) continue;
            answer[curIdx++] = arr[i];
        }
        return answer;
    }
}
