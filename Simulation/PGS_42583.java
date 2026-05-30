// PGS - 42583
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/42583

import java.util.*;

class Solution {
    
    static class Truck {
        int weight;
        int enteredAt;
        
        public Truck(int weight, int enteredAt) {
            this.weight = weight;
            this.enteredAt = enteredAt;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int curWeight = 0, time = 0;
        Queue<Truck> bridge = new ArrayDeque<>(bridge_length);
        int n = truck_weights.length;
        for (int i=0; i<n; i++) {
            if (!bridge.isEmpty() && time - bridge.peek().enteredAt >= bridge_length) {
                curWeight -= bridge.peek().weight;
                bridge.poll();
            }
            if (curWeight + truck_weights[i] <= weight && bridge.size() < bridge_length) {
                bridge.add(new Truck(truck_weights[i], time));
                curWeight += truck_weights[i];
            } else {
                i--;
            }
            time++;
        }
        return time + bridge_length;
    }

}
