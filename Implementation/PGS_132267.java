// PGS - 132267
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/132267

import java.util.*;

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while (n / a > 0) {
            int cur = b * (n / a);
            answer += cur;
            n %= a;
            n += cur;
        }
        return answer;
    }
}
