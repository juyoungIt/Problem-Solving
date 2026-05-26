// PGS - 42586
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/42586

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int[] elapsed = new int[n];
        for (int i=0; i<n; i++) {
            int remain = 100 - progresses[i];
            elapsed[i] = remain / speeds[i] + ((remain % speeds[i] > 0) ? 1 : 0);
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int lastElapsed = elapsed[0];
        for (int i=1; i<n; i++) {
            if (elapsed[i] <= lastElapsed) {
                stack.push(stack.pop() + 1);
            } else {
                lastElapsed = elapsed[i];
                stack.push(1);
            }
        }
        int[] answer = new int[stack.size()];
        for (int i=stack.size()-1; i>=0; i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}
