// PGS - 181847
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181847

import java.util.*;

class Solution {
    public String solution(String n_str) {
        boolean isPassed = false;
        int index = 0;
        int len = n_str.length();
        for (index=0; index<len; index++) {
            if (n_str.charAt(index) != '0') {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (index < len) {
            sb.append(n_str.charAt(index++));
        }
        return sb.toString();
    }
}
