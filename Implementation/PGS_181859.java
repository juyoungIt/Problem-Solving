// PGS - 181859
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181859

import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> stk = new ArrayList<>();
        int len = arr.length;
        int i = 0;
        while (i < len) {
            if (stk.size() == 0) {
                stk.add(arr[i++]);
            } else {
                if (stk.get(stk.size() - 1) == arr[i]) {
                    stk.remove(stk.size() - 1);
                    i++;
                } else {
                    stk.add(arr[i++]);
                }
            }
        }
        return stk.size() > 0 ? stk.stream().mapToInt(Integer::intValue).toArray() : new int[]{ -1 };
    }
}
