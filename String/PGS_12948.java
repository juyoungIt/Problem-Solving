// PGS - 12948
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/12948

import java.util.*;

class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        int len = phone_number.length();
        for (int i=0; i<len-4; i++) {
            sb.append('*');
        }
         for (int i=len-4; i<len; i++) {
            sb.append(phone_number.charAt(i));
        }
        return sb.toString();
    }
}
