// PGS - 120894
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120894

import java.util.*;

class Solution {
    public long solution(String numbers) {
        Map<String, Integer> valueMap = new HashMap<>();
        valueMap.put("zero", 0); valueMap.put("one", 1); valueMap.put("two", 2);
        valueMap.put("three", 3); valueMap.put("four", 4); valueMap.put("five", 5);
        valueMap.put("six", 6); valueMap.put("seven", 7); valueMap.put("eight", 8);
        valueMap.put("nine", 9);
        long answer = 0;
        int left = 0, right = 0;
        while (right <= numbers.length()) {
            String sub = numbers.substring(left, right);
            if (!valueMap.containsKey(sub)) {
                right++;
                continue;
            }
            answer *= 10;
            answer += valueMap.get(sub);
            left = right;
        }
        return answer;
    }
}
