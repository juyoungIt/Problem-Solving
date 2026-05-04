// PGS - 138477
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/138477

import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int n = score.length;
        int[] announce = new int[n];
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for (int i=0; i<n; i++) {
            if (pQueue.size() < k) {
                pQueue.add(score[i]);
            } else {
                if (pQueue.peek() < score[i]) {
                    pQueue.poll();
                    pQueue.add(score[i]);
                }
            }
            announce[i] = pQueue.peek();
        }
        return announce;
    }
}
