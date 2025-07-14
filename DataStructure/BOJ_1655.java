// BOJ - 1655
// Problem Sheet - https://www.acmicpc.net/problem/1655

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (maxHeap.size() == minHeap.size()) maxHeap.add(x);
            else minHeap.add(x);
            if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                int max = maxHeap.poll();
                int min = minHeap.poll();
                maxHeap.add(min);
                minHeap.add(max);
            }
            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}