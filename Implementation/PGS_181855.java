// PGS - 181855
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181855

import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (String str : strArr) {
            int len = str.length();
            countMap.put(len, countMap.getOrDefault(len, 0) + 1);
        }
        int answer = 0;
        for (int count : countMap.values()) {
            answer = Math.max(answer, count);
        }
        return answer;
    }
}
