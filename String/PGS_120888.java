// PGS - 120888
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120888

import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        int len = my_string.length();
        for (int i=0; i<len; i++) {
            char c = my_string.charAt(i);
            if (set.contains(c)) continue;
            set.add(c);
            sb.append(c);
        }
        return sb.toString();
    }
}
