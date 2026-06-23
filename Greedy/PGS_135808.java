// PGS - 135808
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/135808

import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int answer = 0;
        int size = score.length;
        while (size > 0) {
            for (int i=0; i<m; i++) {
                if (size <= 0) break;
                if (i == m-1) answer += score[size - 1] * m;
                size--;
            }
        }
        return answer;
    }
}
