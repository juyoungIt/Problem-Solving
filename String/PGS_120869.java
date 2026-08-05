// PGS - 120869
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120869

import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(spell);
        for (String c : spell) {
            sb.append(c);
        }
        String target = sb.toString();
        for (String word : dic) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            StringBuilder tmp = new StringBuilder();
            for (char c : arr) {
                tmp.append(c);
            }
            word = tmp.toString();
            if (word.equals(target)) {
                return 1;
            }
        }
        return 2;
    }
}
