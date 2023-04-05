// BOJ - 11101
// Problem Sheet - https://www.acmicpc.net/problem/11101

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> timeCostMapper = new HashMap<>();
        PriorityQueue<Integer> timeCostStorage = new PriorityQueue<>();

        int numberOfTestCases = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfTestCases ; i++) {
            String[] conditions = bf.readLine().split(",");
            for(String condition : conditions) {
                String[] tokens = condition.split(":");
                timeCostMapper.put(tokens[0], Integer.parseInt(tokens[1]));
            }
            String[] solutions = bf.readLine().split("\\|");
            for(String solution : solutions) {
                String[] items = solution.split("&");
                PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
                for(String item : items) {
                    pQueue.add(timeCostMapper.get(item));
                }
                timeCostStorage.add(pQueue.poll());
            }
            sb.append(timeCostStorage.poll()).append("\n");
            timeCostMapper.clear();
            timeCostStorage.clear();
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}