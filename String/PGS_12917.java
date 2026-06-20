// PGS - 12917
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/12917

import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        char[] arr = new char[len];
        for (int i=0; i<len; i++) {
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr);
        for (int i=len-1; i>=0; i--) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
