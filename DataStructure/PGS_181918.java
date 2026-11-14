// PGS - 181918
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181918

import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> stk = new ArrayDeque<>();
        int i=0;
        while (i < arr.length) {
            if (stk.isEmpty()) {
                stk.addLast(arr[i++]);
            } else {
                if (stk.peekLast() < arr[i]) {
                    stk.addLast(arr[i++]);
                } else {
                    stk.pollLast();
                }
            }
        }
        return stk.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
