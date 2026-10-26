// PGS - 181921
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181921

import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        for (int i=l; i<=r; i++) {
            if (isValid(i)) {
                list.add(i);
            }
        }
        int[] answer = list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        return answer.length == 0 ? new int[]{-1} : answer;
    }
    
    private static boolean isValid(int n) {
        while (n > 0) {
            if (n % 10 != 0 && n % 10 != 5) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
