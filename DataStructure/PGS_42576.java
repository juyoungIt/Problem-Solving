// PGS - 42576
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/42576

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String p : participant) {
            countMap.put(p, countMap.getOrDefault(p, 0) + 1);
        }
        for (String c : completion) {
            countMap.put(c, countMap.get(c) - 1);
            if (countMap.get(c) == 0) {
                countMap.remove(c);
            }
        }
        List<String> remains = new ArrayList<>(countMap.keySet());
        return remains.get(0);
    }
}
