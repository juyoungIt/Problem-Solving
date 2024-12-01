// BOJ - 24155
// Problem Sheet - https://www.acmicpc.net/problem/24155

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n];
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0 ; i<n ; i++) {
            int score = Integer.parseInt(br.readLine());
            scores[i] = score;
            pQueue.add(score);
        }

        Map<Integer, Integer> rankMapper = new HashMap<>();
        int curRank = 1;
        while (!pQueue.isEmpty()) {
            int topScore = pQueue.poll();
            if (rankMapper.containsKey(topScore)) {
                curRank++;
            } else {
                rankMapper.put(topScore, curRank++);
            }
        }
        Arrays.stream(scores).forEach(score -> sb.append(rankMapper.get(score)).append("\n"));

        System.out.println(sb);
        br.close();
    }
}