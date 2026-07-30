// PGS - 120844
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/120844

import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int number : numbers) {
            deque.addLast(number);
        }
        if (direction.equals("right")) {
            deque.addFirst(deque.pollLast());
        } else {
            deque.addLast(deque.pollFirst());
        }
        return deque.stream().mapToInt(Integer::intValue).toArray();
    }
}
