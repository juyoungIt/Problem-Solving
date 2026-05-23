// PGS - 12906
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/12906

import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int e : arr) {
            if (!stack.isEmpty() && stack.peek() == e) continue;
            stack.push(e);
        }
        int n = stack.size();
        int[] answer = new int[n];
        for (int i=n-1; i>=0; i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}
