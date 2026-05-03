// PGS - 142086
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/142086

import java.util.*;

class Solution {
    public int[] solution(String s) {
        int len = s.length();
        int[] answer = new int[len];
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i=0; i<len; i++) {
            char c = s.charAt(i);
            if (indexMap.containsKey(c)) {
                answer[i] = i - indexMap.get(c);
            } else {
                answer[i] = -1;
            }
            indexMap.put(c, i);
        }
        return answer;
    }
}
