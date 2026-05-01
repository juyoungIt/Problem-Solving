// PGS - 178871
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/178871

import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int n = players.length;
        String[] answer = new String[n];
        System.arraycopy(players, 0, answer, 0, n);
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i=0 ; i<n ; i++) {
            indexMap.put(players[i], i);
        }
        for (String calling : callings) {
            int targetIndex = indexMap.get(calling);
            String prev = answer[targetIndex - 1];
            swap(answer, targetIndex - 1, targetIndex);
            indexMap.put(calling, targetIndex - 1);
            indexMap.put(prev, targetIndex);
        }
        return answer;
    }
    
    private void swap(String[] arr, int idx1, int idx2) {
        String tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
