// PGS - 181928
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181928

import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        StringBuilder oddBuffer = new StringBuilder();
        StringBuilder evenBuffer = new StringBuilder();
        for (int num : num_list) {
            if (num % 2 == 0) {
                evenBuffer.append(num);
            } else {
                oddBuffer.append(num);
            }
        }
        int odd = Integer.parseInt(oddBuffer.toString());
        int even = Integer.parseInt(evenBuffer.toString());
        return odd + even;
    }
}
