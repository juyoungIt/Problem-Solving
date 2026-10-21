// PGS - 181893
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181893

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int len = query.length;
        for (int i=0; i<len; i++) {
            if (i % 2 == 0) {
                int newLen = query[i] + 1;
                int[] newArr = new int[newLen];
                System.arraycopy(arr, 0, newArr, 0, newLen);
                arr = newArr;
            } else {
                int newLen = arr.length - query[i];
                int[] newArr = new int[newLen];
                System.arraycopy(arr, query[i], newArr, 0, newLen);
                arr = newArr;
            }
        }
        return arr;
    }
}
