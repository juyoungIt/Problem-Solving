// PGS - 181912
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181912

import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        return Arrays.stream(intStrs)
            .mapToInt(intStr -> Integer.parseInt(intStr.substring(s, s + l)))
            .filter(v -> v > k)
            .toArray();
    }
}
