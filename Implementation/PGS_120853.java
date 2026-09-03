// PGS - 120853
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120853

import java.util.*;

class Solution {
    public int solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int answer = 0, prev = 0;
        while (st.hasMoreTokens()) {
            String cur = st.nextToken();
            if (cur.equals("Z")) {
                answer -= prev;
            } else {
                int number = Integer.parseInt(cur);
                answer += number;
                prev = number;
            }
        }
        return answer;
    }
}
