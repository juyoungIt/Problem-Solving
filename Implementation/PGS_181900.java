// PGS - 181900
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181900

import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        int len = my_string.length();
        boolean[] isDeleted = new boolean[len];
        for (int index : indices) {
            isDeleted[index] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<len; i++) {
            if (isDeleted[i]) continue;
            sb.append(my_string.charAt(i));
        }
        return sb.toString();
    }
}
