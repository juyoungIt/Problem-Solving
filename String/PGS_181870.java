// PGS - 181870
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181870

import java.util.*;

class Solution {
    
    private static final String TARGET = "ad";
    
    public String[] solution(String[] strArr) {
        List<String> answer = new ArrayList<>();
        for (String str : strArr) {
            if (containsAD(str)) continue;
            answer.add(str);
        }
        return answer.stream().toArray(String[]::new);
    }
    
    private boolean containsAD(String str) {
        for (int i=0; i<=str.length()-2; i++) {
            if (str.substring(i, i + 2).equals(TARGET)) {
                return true;
            }
        }
        return false;
    }
}
