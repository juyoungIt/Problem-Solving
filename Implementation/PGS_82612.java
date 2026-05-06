// PGS - 82612
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/82612

import java.util.*;

class Solution {
    public long solution(int price, int money, int count) {
        long[] acc = new long[count + 1];
        for (int i=1; i<=count; i++) {
            acc[i] += acc[i - 1] + price * i;
        }
        return Math.max(acc[count] - money, 0);
    }
}
