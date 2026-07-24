// PGS - 120862
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120862

import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int len = numbers.length;
        Arrays.sort(numbers);
        return Math.max(numbers[0] * numbers[1], numbers[len-2] * numbers[len-1]);
    }
}
