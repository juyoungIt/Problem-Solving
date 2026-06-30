// PGS - 160586
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/160586

import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> indexMap = new HashMap<>();
        for (String key : keymap) {
            for (int i=0; i<key.length(); i++) {
                char c = key.charAt(i);
                if (indexMap.containsKey(c) && indexMap.get(c) <= i) continue;
                indexMap.put(c, i);
            }
        }
        int[] answer = new int[targets.length];
        for (int i=0; i<targets.length; i++) {
            int clickCount = 0;
            for (int j=0; j<targets[i].length(); j++) {
                int count = indexMap.getOrDefault(targets[i].charAt(j), -1);
                if (count < 0) {
                    clickCount = -1;
                    break;
                }
                clickCount += (count + 1);
            }
            answer[i] = clickCount;
        }
        return answer;
    }
}
