// PGS - 181835
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181835

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        if (k % 2 != 0) {
            return Arrays.stream(arr)
                .map(e -> e * k)
                .toArray();
        } else {
            return Arrays.stream(arr)
                .map(e -> e + k)
                .toArray();
        }
    }
}
