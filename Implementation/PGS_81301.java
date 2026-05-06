// PGS - 81301
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/81301

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<String, Integer> valueMap = new HashMap<>();
        valueMap.put("zero", 0); valueMap.put("one", 1); valueMap.put("two", 2);
        valueMap.put("three", 3); valueMap.put("four", 4); valueMap.put("five", 5);
        valueMap.put("six", 6); valueMap.put("seven", 7); valueMap.put("eight", 8);
        valueMap.put("nine", 9);
        int lastIdx = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                answer *= 10;
                answer += (int) (c - '0');
                lastIdx = i + 1;
            } else {
                String str = s.substring(lastIdx, i + 1);
                if (valueMap.containsKey(str)) {
                    answer *= 10;
                    answer += valueMap.get(str);
                    lastIdx = i + 1;
                }
            }
        }
        return answer;
    }
}
