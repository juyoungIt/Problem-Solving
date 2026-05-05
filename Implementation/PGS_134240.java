// PGS - 134240
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/134240

import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        int n = food.length;
        for (int i=1; i<n; i++) {
            int count = food[i] % 2 == 0 ? food[i] : food[i] - 1;
            for (int j=0 ; j<count/2 ; j++) {
                sb.append(i);
            }
        }
        String left = sb.toString();
        String right = sb.reverse().toString();
        return left + "0" + right;
    }
}
