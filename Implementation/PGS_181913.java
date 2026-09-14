// PGS - 181913
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181913

import java.util.*;

class Solution {
    public String solution(String my_string, int[][] queries) {
        int len = my_string.length();
        int[] indexArr = new int[len];
        for (int i=0; i<len; i++) {
            indexArr[i] = i;
        }
        for (int[] query : queries) {
            int s = query[0];
            int e = query[1];
            reverse(indexArr, s, e);
        }
        char[] answerArr = new char[len];
        for (int i=0; i<len; i++) {
            answerArr[i] = my_string.charAt(indexArr[i]);
        }
        return new String(answerArr);
    }
    
    private void reverse(int[] arr, int s, int e) {
        while (s < e) {
            int tmp = arr[s];
            arr[s] = arr[e];
            arr[e] = tmp;
            s++;
            e--;
        }
    }
}
