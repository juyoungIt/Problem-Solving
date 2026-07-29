// PGS - 181919
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181919

import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> sequence = new ArrayList<>();
        sequence.add(n);
        while (n != 1) {
            n = n % 2 == 0 ? n / 2 : 3 * n + 1;
            sequence.add(n);
        }
        return sequence.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
