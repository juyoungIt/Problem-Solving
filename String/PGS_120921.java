// PGS - 120921
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120921

import java.util.*;

class Solution {
    public int solution(String A, String B) {
        int len = A.length();
        for (int k = 0; k < len; k++) {
            String rotated = A.substring(len - k) + A.substring(0, len - k);
            if (rotated.equals(B)) {
                return k;
            }
        }
        return -1;
    }
}
