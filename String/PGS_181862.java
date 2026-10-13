// PGS - 181862
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181862

import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] answer = Arrays.stream(myStr.split("[abc]"))
            .filter(e -> !e.isEmpty())
            .toArray(String[]::new);
        return answer.length == 0 ? new String[]{"EMPTY"} : answer;
    }
}
