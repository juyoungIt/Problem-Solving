// BOJ - 1927
// Problem Sheet - https://www.acmicpc.net/problem/1927

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(); // 오름차순으로 정렬하는 우선순위 큐

        int n = Integer.parseInt(bf.readLine()); // 연산의 수
        for(int i=0 ; i<n ; i++) {
            int command = Integer.parseInt(bf.readLine());
            if(command == 0) {
                if(pQueue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pQueue.poll());
                }
            } else {
                pQueue.add(command);
            }
        }

        bf.close();
        System.exit(0);
    }
}