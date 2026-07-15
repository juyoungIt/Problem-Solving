// PGS - 120583
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120583

import java.util.*;

class Solution {
    public long solution(int[] array, int n) {
        return Arrays.stream(array)
            .filter(e -> e == n)
            .count();
    }
}
