// PGS - 120826
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120826

import java.util.*;

class Solution {
    public String solution(String my_string, String letter) {
        StringBuilder sb = new StringBuilder();
        char[] arr = my_string.toCharArray();
        for (char c : arr) {
            if (c == letter.charAt(0)) continue;
            sb.append(c);
        }
        return sb.toString();
    }
}
