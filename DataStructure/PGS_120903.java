// PGS - 120903
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120903

import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        Set<String> used = new HashSet<>();
        for (String str : s1) {
            used.add(str);
        }
        int answer = 0;
        for (String str : s2) {
            if (used.contains(str)) {
                answer++;
            }
        }
        return answer;
    }
}
