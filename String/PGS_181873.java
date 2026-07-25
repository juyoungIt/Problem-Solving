// PGS - 181873
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181873

import java.util.*;

class Solution {
    public String solution(String my_string, String alp) {
        StringBuilder sb = new StringBuilder();
        int len = my_string.length();
        for (int i=0; i<len; i++) {
            char c = my_string.charAt(i);
            if (c == alp.charAt(0)) {
                c = Character.toUpperCase(c);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
