// BOJ - 30310
// Problem Sheet - https://www.acmicpc.net/problem/30310

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        String[] input = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            pQueue.add(Integer.parseInt(input[i]));
        }

        int answer = 0;
        int pollCount = 0;
        while (!pQueue.isEmpty()) {
            if (pollCount == 2) break;
            answer += pQueue.poll();
            pollCount++;
        }

        System.out.println(answer);
        br.close();
    }
}