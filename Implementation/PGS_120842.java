// PGS - 120842
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120842

import java.util.*;

class Solution {
    public int[][] solution(int[] num_list, int n) {
        int len = num_list.length;
        int[][] answer = new int[len / n][n];
        int curIndex = 0;
        while (curIndex < len) {
            answer[curIndex / n][curIndex % n] = num_list[curIndex++];
        }
        return answer;
    }
}
