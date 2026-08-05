// PGS - 181839
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181839

import java.util.*;

class Solution {
    public int solution(int a, int b) {
        int remainderA = a % 2, remainderB = b % 2;
        if (remainderA > 0 && remainderB > 0) {
            return a * a + b * b;
        } else if (remainderA == 0 && remainderB == 0) {
            return Math.abs(a - b);
        } else {
            return 2 * (a + b);
        }
    }
}
