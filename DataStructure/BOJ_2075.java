// BOJ - 2075
// Problem Sheet - https://www.acmicpc.net/problem/2075

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        String[] row = br.readLine().split(" ");
        for (int j=0 ; j<n ; j++) pQueue.add(Integer.parseInt(row[j]));
        for (int i=1 ; i<n ; i++) {
            row = br.readLine().split(" ");
            for (int j=0 ; j<n ; j++) {
                pQueue.add(Integer.parseInt(row[j]));
                pQueue.poll();
            }
        }

        System.out.println(pQueue.peek());
        br.close();
    }
}