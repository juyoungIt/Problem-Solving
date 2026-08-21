// PGS - 120850
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120850

import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        List<Integer> numbers = new ArrayList<>();
        for (int i=0; i<my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (!Character.isDigit(c)) {
                continue;
            }
            numbers.add((int) (c - '0'));
        }
        return numbers.stream()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
