// PGS - 120852
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120852

import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> answer = new HashSet<>();
        int divider = 2;
        while (n > divider) {
            if (n % divider == 0) {
                answer.add(divider);
                n /= divider;
            } else {
                divider++;
            }
        }
        answer.add(n);
        return answer.stream()
            .mapToInt(Integer::intValue)
            .sorted()
            .toArray();
    }
}
