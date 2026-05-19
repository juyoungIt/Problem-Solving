// PGS - 12982
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/12982

import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        for (int i=0; i<d.length; i++) {
            if (budget - d[i] < 0) {
                break;
            }
            budget -= d[i];
            answer++;
        }
        return answer;
    }
}
