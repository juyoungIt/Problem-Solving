// PGS - 150370
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/150370

import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int cur = dateToInt(today);
        Map<Character, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] part = term.split(" ");
            termMap.put(part[0].charAt(0), Integer.parseInt(part[1]));
        }
        List<Integer> expired = new ArrayList<>();
        for (int i=0; i<privacies.length; i++) {
            String[] part = privacies[i].split(" ");
            int end = dateToInt(part[0]) + termMap.get(part[1].charAt(0)) * 28;
            if (end <= cur) {
                expired.add(i + 1);
            }
        }
        int len = expired.size();
        int[] answer = new int[len];
        for (int i=0; i<len; i++) {
            answer[i] = expired.get(i);
        }
        return answer;
    }
    
    private int dateToInt(String date) {
        int[] arr = Arrays.stream(date.split("\\."))
            .mapToInt(Integer::parseInt)
            .toArray();
        return (arr[0] * 12 * 28) + (arr[1] * 28) + arr[2];
    }
}
