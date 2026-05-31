// PGS - 12940
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/12940

import java.util.*;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int a = Math.min(n, m);
        int b = Math.max(n, m);
        answer[0] = getGCD(a, b);
        answer[1] = getLCM(a, b, answer[0]);
        return answer;
    }
    
    private int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }
    
    private int getLCM(int a, int b, int gcd) {
        return a * b / gcd;
    }
}
