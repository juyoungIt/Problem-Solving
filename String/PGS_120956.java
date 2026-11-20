// PGS - 120956
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120956

import java.util.*;

class Solution {
    
    private static final String[] WORDS = {"aya", "ye", "woo", "ma"};

    public int solution(String[] babbling) {
        int answer = 0;
        for (String s : babbling) {
            if (isPronounceable(s)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isPronounceable(String s) {
        boolean[] used = new boolean[WORDS.length];
        int index = 0;
        while (index < s.length()) {
            int matched = -1;
            for (int i = 0; i < WORDS.length; i++) {
                if (!used[i] && s.startsWith(WORDS[i], index)) {
                    matched = i;
                    break;
                }
            }
            if (matched == -1) {
                return false;
            }
            used[matched] = true;
            index += WORDS[matched].length();
        }
        return true;
    }
}
