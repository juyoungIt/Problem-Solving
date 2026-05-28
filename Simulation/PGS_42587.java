// PGS - 42587
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/42587

import java.util.*;

class Solution {
    
    static class Task {
        int index;
        int priority;
        
        public Task(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Task> queue = new LinkedList<>();
        int n = priorities.length;
        for (int i=0; i<n; i++) {
            pq.add(priorities[i]);
            queue.add(new Task(i, priorities[i]));
        }
        int sequence = 1;
        while (true) {
            int topPriority = pq.peek();
            Task candidate = queue.poll();
            if (candidate.priority == topPriority) {
                if (candidate.index == location) break;
                pq.poll();
                sequence++;
            } else {
                queue.add(candidate);
            }
        }
        return sequence;
    }
}
