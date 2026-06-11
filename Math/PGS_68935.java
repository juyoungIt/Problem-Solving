// PGS - 68935
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/68935

import java.util.*;

class Solution {
    public int solution(int n) {
        Queue<Integer> queue = new LinkedList<>();
        while (n / 3 > 0) {
            queue.add(n % 3);
            n /= 3;
        }
        queue.add(n % 3);
        int answer = 0;
        while (!queue.isEmpty()) {
            answer += queue.poll() * (int) Math.pow(3, queue.size());
        }
        return answer;
    }
}
