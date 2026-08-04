// PGS - 181925
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181925

import java.util.*;

class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<numLog.length; i++) {
            int diff = numLog[i] - numLog[i - 1];
            if (diff == 1) sb.append('w');
            else if (diff == -1) sb.append('s');
            else if (diff == 10) sb.append('d');
            else if (diff == -10) sb.append('a');
            else throw new IllegalArgumentException("Invalid Arguments...");
        }
        return sb.toString();
    }
}
