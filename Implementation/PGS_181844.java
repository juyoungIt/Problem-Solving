// PGS - 181844
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181844

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        Set<Integer> deleted = new HashSet<>();
        for (int d : delete_list) {
            deleted.add(d);
        }
        List<Integer> remain = new ArrayList<>();
        for (int e : arr) {
            if (deleted.contains(e)) continue;
            remain.add(e);
        }
        int[] answer = new int[remain.size()];
        for (int i=0; i<remain.size(); i++) {
            answer[i] = remain.get(i);
        }
        return answer;
    }
}
