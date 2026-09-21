// PGS - 181858
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181858

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        List<Integer> tmp = new ArrayList<>();
        for (int e : arr) {
            if (set.size() == k) break;
            if (!set.contains(e)) {
                set.add(e);
                tmp.add(e);
            }
        }
        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        for (int i=0; i<set.size(); i++) {
            answer[i] = tmp.get(i);
        }
        return answer;
    }
}
