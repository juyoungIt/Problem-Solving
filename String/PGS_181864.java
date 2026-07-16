// PGS - 181864
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181864

import java.util.*;

class Solution {
    public int solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder();
        int len = myString.length();
        for (int i=0; i<len; i++) {
            sb.append(myString.charAt(i) == 'A' ? 'B' : 'A');
        }
        return sb.toString().contains(pat) ? 1 : 0;
    }
}
