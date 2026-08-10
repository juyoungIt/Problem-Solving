// PGS - 181879
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181879

import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int len = num_list.length;
        if (len >= 11) {
            return Arrays.stream(num_list).sum();
        } else {
            return Arrays.stream(num_list).reduce(1, (a, b) -> a * b);
        }
    }
}
