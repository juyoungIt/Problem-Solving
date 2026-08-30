// PGS - 120886
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120886

import java.util.*;

class Solution {
    public int solution(String before, String after) {
        int[] beforeCount = new int[26];
        int[] afterCount = new int[26];
        for (int i=0; i<before.length(); i++) {
            beforeCount[before.charAt(i) - 'a']++;
        }
        for (int i=0; i<after.length(); i++) {
            afterCount[after.charAt(i) - 'a']++;
        }
        return Arrays.equals(beforeCount, afterCount) ? 1 : 0;
    }
}
