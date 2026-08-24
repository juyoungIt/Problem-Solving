// PGS - 120896
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120896

import java.util.*;

class Solution {
    public String solution(String s) {
        int[] count = new int[26];
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<26; i++) {
            if (count[i] != 1) continue;
            sb.append((char) ('a' + i));
        }
        return sb.toString();
    }
}
