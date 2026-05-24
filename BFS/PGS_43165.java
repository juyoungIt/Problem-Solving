// PGS - 43165
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/43165

import java.util.*;

class Solution {
    
    static class Node {
        int value;
        int index;
        
        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    
    public int solution(int[] numbers, int target) {
        int[] m = { -1, 1 };
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(numbers[0], 0));
        queue.add(new Node(-numbers[0], 0));
        int answer = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.index == numbers.length - 1) {
                if (cur.value == target) answer++;
                continue;
            }
            for (int i=0; i<2; i++) {
                int newValue = cur.value + numbers[cur.index + 1] * m[i];
                queue.add(new Node(newValue, cur.index + 1));
            }
        }
        return answer;
    }
    
}
