// PGS - 120880
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120880

import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        return Arrays.stream(numlist)
            .boxed()
            .sorted((n1, n2) -> {
                int diff1 = Math.abs(n1 - n);
                int diff2 = Math.abs(n2 - n);
                if (diff1 == diff2) {
                    return n2 - n1;
                }
                return diff1 - diff2;
            })
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
