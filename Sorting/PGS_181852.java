// PGS - 181852
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181852

import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        return Arrays.stream(num_list)
            .sorted()
            .skip(5)
            .toArray();
    }
}
