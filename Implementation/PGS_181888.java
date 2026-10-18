// PGS - 181888
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/181888

import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int len = num_list.length;
        int[] answer = new int[(len + n - 1) / n];
        int count = 0;
        for (int i=0; i<len; i+=n) {
            answer[count++] = num_list[i];
        }
        return answer;
    }
}
