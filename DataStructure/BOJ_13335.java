// BOJ - 13335
// Problem Sheet - https://www.acmicpc.net/problem/13335

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int currentWeight = 0;
        int currentTruckCount = 0;
        int totalTimeCost = 0;

        int numberOfTrucks = Integer.parseInt(st.nextToken());
        int lengthOfBridge = Integer.parseInt(st.nextToken());
        int maxPayloadOfBridge = Integer.parseInt(st.nextToken());

        Queue<Integer> waitingQueue = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        for(int i=0 ; i<lengthOfBridge ; i++) {
            bridge.add(0);
        }

        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<numberOfTrucks ; i++) {
            waitingQueue.add(Integer.parseInt(st.nextToken()));
        }

        while(true) {
            if(waitingQueue.isEmpty()) {
                totalTimeCost += lengthOfBridge;
                break;
            }
            int weight = waitingQueue.peek();
            if(currentTruckCount >= lengthOfBridge || currentWeight + weight > maxPayloadOfBridge) {
                if(bridge.peek() > 0) {
                    currentTruckCount--;
                }
                currentWeight -= bridge.poll();
                if(currentWeight + waitingQueue.peek() <= maxPayloadOfBridge) {
                    currentWeight += waitingQueue.peek();
                    bridge.add(waitingQueue.poll());
                    currentTruckCount++;
                } else {
                    bridge.add(0);
                }
                totalTimeCost++;
            } else {
                if(bridge.peek() > 0) {
                    currentTruckCount--;
                }
                currentWeight -= bridge.poll();
                currentWeight += waitingQueue.poll();
                bridge.add(weight);
                totalTimeCost++;
                currentTruckCount++;
            }
        }

        System.out.println(totalTimeCost);

        bf.close();
        System.exit(0);
    }
}