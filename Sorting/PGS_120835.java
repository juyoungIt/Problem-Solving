// PGS - 120835
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120835

import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int len = emergency.length;
        int[] index = new int[101];
        int[] sorted = emergency.clone();
        Arrays.sort(sorted);
        for (int i=0; i<len; i++) {
            index[sorted[i]] = len - i;
        }
        int[] answer = new int[len];
        for (int i=0; i<len; i++) {
            answer[i] = index[emergency[i]];
        }
        return answer;
    }
}
