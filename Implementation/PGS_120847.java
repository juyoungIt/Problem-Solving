// PGS - 120847
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120847

import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int len = numbers.length;
        return numbers[len - 2] * numbers[len - 1];
    }
}
