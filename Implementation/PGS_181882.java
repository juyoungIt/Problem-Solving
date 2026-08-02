// PGS - 181882
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181882

import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        return Arrays.stream(arr)
            .map(e -> {
                if (e >= 50 && e % 2 == 0) return e / 2;
                else if (e < 50 && e % 2 == 1) return e * 2;
                else return e;
            })
            .toArray();
    }
}
