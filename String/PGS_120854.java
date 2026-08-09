// PGS - 120854
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120854

import java.util.*;

class Solution {
    public int[] solution(String[] strlist) {
        return Arrays.stream(strlist)
            .mapToInt(String::length)
            .toArray();
    }
}
