// PGS - 181909
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181909

import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        int len = my_string.length();
        String[] answer = new String[len];
        for (int i=0; i<len; i++) {
            answer[i] = my_string.substring(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}
