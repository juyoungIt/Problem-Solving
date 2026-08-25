// PGS - 181905
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181905

import java.util.*;

class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder();
        int len = my_string.length();
        for (int i=0; i<s; i++) {
            sb.append(my_string.charAt(i));
        }
        for (int i=e; i>=s; i--) {
            sb.append(my_string.charAt(i));
        }
        for (int i=e+1; i<len; i++) {
            sb.append(my_string.charAt(i));
        }
        return sb.toString();
    }
}
