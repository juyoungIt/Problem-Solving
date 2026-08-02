// PGS - 181849
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181849

import java.util.*;

class Solution {
    public int solution(String num_str) {
        return Arrays.stream(num_str.split(""))
            .mapToInt(Integer::parseInt)
            .sum();
    }
}
