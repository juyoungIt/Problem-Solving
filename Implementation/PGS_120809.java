// PGS - 120809
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120809

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        return Arrays.stream(numbers)
            .map(e -> e * 2)
            .toArray();
    }
}
