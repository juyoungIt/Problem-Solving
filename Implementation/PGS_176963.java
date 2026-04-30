// PGS - 176963
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/176963

import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> scores = new HashMap<>();
        for (int i=0 ; i<name.length ; i++) {
            scores.put(name[i], yearning[i]);
        }
        for (int i=0 ; i<photo.length ; i++) {
            for (int j=0 ; j<photo[i].length ; j++) {
                answer[i] += scores.getOrDefault(photo[i][j], 0);
            }
        }
        return answer;
    }
}
