// BOJ - 22993
// Problem Sheet - https://www.acmicpc.net/problem/22993

import java.util.*;
import java.io.*;

public class Main {

    enum Message {
        Yes, No
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] attackPowers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for (int i=1 ; i<n ; i++) {
            pQueue.add(attackPowers[i]);
        }

        long curPower = attackPowers[0];
        while (!pQueue.isEmpty()) {
            if (pQueue.peek() >= curPower) {
                break;
            }
            curPower += pQueue.poll();
        }

        System.out.println(pQueue.isEmpty() ? Message.Yes : Message.No);

        br.close();
        System.exit(0);
    }
}