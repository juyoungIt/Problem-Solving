// PGS - 1845
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/1845

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int size = nums.length / 2;
        Set<Integer> pockets = new HashSet<>();
        for (int num : nums) {
            pockets.add(num);
        }
        return Math.min(pockets.size(), size);
    }
}
