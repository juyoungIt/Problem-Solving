// BOJ - 33094
// Problem Sheet - https://www.acmicpc.net/problem/33094

import java.util.*;
import java.io.*;

public class Main {

    private static int n, m, k;
    private static int[] milks;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        n = Integer.parseInt(row[0]);
        m = Integer.parseInt(row[1]);
        k = Integer.parseInt(row[2]);
        milks = new int[n];
        row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            milks[i] = Integer.parseInt(row[i]);
        }
        br.close();
    }

    private static int solve() {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        int days;
        for (days=0 ; days<n ; days++) {
            pQueue.add(milks[days]);
            m -= milks[days];
            if (m >= 0) continue;
            if (k > 0) {
                m += pQueue.poll();
                k--;
            } else {
                return days;
            }
        }
        return n;
    }

}