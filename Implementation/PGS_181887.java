// PGS - 181887
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181887

import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int[] sum = new int[2];
        for (int i=0; i<num_list.length; i++) {
            sum[i % 2] += num_list[i];
        }
        return Math.max(sum[0], sum[1]);
    }
}
