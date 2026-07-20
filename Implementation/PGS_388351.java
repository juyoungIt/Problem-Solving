// PGS - 388351
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/388351

import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;
        for (int i=0; i<n; i++) {
            boolean isValid = true;
            for (int j=0; j<7; j++) {
                int curDay = (startday - 1 + j) % 7 + 1;
                if (curDay > 5) continue;
                if (isNotValid(schedules[i], timelogs[i][j])) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) answer++;
        }
        return answer;
    }
    
    private boolean isNotValid(int baseTime, int curTime) {
        baseTime = convert(baseTime);
        curTime = convert(curTime);
        return curTime > baseTime + 10;
    }
    
    private int convert(int time) {
        return time / 100 * 60 + time % 100;
    }
}
