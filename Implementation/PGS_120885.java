// PGS - 120885
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120885

import java.util.*;

class Solution {
    public String solution(String bin1, String bin2) {
        int carry = 0;
        int len = Math.max(bin1.length(), bin2.length());
        String formattedBin1 = getFormattedBin(bin1, len);
        String formattedBin2 = getFormattedBin(bin2, len);
        Stack<Integer> stack = new Stack<>();
        for (int i=len-1; i>=0; i--) {
            int d1 = (int) (formattedBin1.charAt(i) - '0');
            int d2 = (int) (formattedBin2.charAt(i) - '0');
            int sum = d1 + d2 + carry;
            if (sum <= 1) {
                stack.push(sum);
                carry = 0;
            } else {
                stack.push(sum % 2);
                carry = 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (carry == 1) {
            stack.push(1);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    
    private String getFormattedBin(String bin, int len) {
        StringBuilder sb = new StringBuilder(bin);
        while (sb.length() < len) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }
}
