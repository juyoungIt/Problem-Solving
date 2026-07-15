// PGS - 181853
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181853

import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        return Arrays.stream(num_list)
            .sorted()
            .limit(5)
            .toArray();
    }
}
