// BOJ - 31860
// Problem Sheet - https://www.acmicpc.net/problem/31860

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> workQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0 ; i<n ; i++) {
            workQueue.add(Integer.parseInt(br.readLine()));
        }

        int prevSatisfaction = 0;
        int days = 0;
        while (!workQueue.isEmpty()) {
            int importance = workQueue.poll();
            int satisfaction = getCurrentSatisfaction(prevSatisfaction, importance);
            sb.append(satisfaction).append("\n");
            if (importance - m > k) {
                workQueue.add(importance - m);
            }
            prevSatisfaction = satisfaction;
            days++;
        }

        System.out.println(days);
        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static int getCurrentSatisfaction(int prevSatisfaction, int importance) {
        return prevSatisfaction / 2 + importance;
    }
}