// PGS - 86051
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/86051

import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        boolean[] isExist = new boolean[10];
        for (int number : numbers) {
            isExist[number] = true;
        }
        int answer = 0;
        for (int i=0; i<10; i++) {
            if (!isExist[i]) {
                answer += i;
            }
        }
        return answer;
    }
}
