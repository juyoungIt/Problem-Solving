// PGS - 42746
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/42746

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int n = numbers.length;
        List<String> strNumbers = new ArrayList<>(n);
        for (int number : numbers) {
            strNumbers.add(Integer.toString(number));
        }
        Collections.sort(strNumbers, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        if (strNumbers.get(0).equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            sb.append(strNumbers.get(i));
        }
        return sb.toString();
    }
}
