// PGS - 131705
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/131705

import java.util.*;

class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int n = number.length;
        for (int i=0; i<n-2; i++) {
            for (int j=i+1; j<n-1; j++) {
                for (int k=j+1; k<n; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
