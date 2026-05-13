// PGS - 77884
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/77884

import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i=left; i<=right; i++) {
            int divisorCount = getDivisorCount(i);
            if (divisorCount % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }
    
    private int getDivisorCount(int n) {
        int count = 0;
        for (int i=1; i<=n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }
}
