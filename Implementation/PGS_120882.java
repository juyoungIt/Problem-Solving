// PGS - 120882
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120882

import java.util.*;

class Solution {  
    public int[] solution(int[][] score) {
        int len = score.length;
        int[] sum = new int[len];
        for (int i=0; i<len; i++) {
            sum[i] = score[i][0] + score[i][1];
        }
        List<Integer> uniqueSum = Arrays.stream(sum)
            .boxed()
            .distinct()
            .sorted(Comparator.reverseOrder())
            .toList();
        int rank = 0;
        Map<Integer, Integer> rankMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i=0; i<len; i++) {
            countMap.put(sum[i], countMap.getOrDefault(sum[i], 0) + 1);
        }
        for (int i=0; i<uniqueSum.size(); i++) {
            rankMap.put(uniqueSum.get(i), rank + 1);
            rank += countMap.get(uniqueSum.get(i));
        }
        int[] answer = new int[len];
        for (int i=0; i<len; i++) {
            answer[i] = rankMap.get(sum[i]);
        }
        return answer;
    }
}
