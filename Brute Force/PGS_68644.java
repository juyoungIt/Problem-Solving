// PGS - 68644
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/68644

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        int n = numbers.length;
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = set.stream()
            .mapToInt(Integer::intValue)
            .sorted()
            .toArray();
        return answer;
    }
}
