// PGS - 12933
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/12933

import java.util.*;

class Solution {
    public long solution(long n) {
        int[] counts = new int[10];
        while (n > 0) {
            counts[(int)(n % 10)]++;
            n /= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=9; i>=0; i--) {
            for (int j=0; j<counts[i]; j++) {
                sb.append(i);
            }
        }
        return Long.parseLong(sb.toString());
    }
}
