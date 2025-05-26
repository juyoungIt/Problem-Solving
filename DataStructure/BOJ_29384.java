// BOJ - 29384
// Problem Sheet - https://www.acmicpc.net/problem/29384

import java.util.*;
import java.io.*;

public class Main {

    private static int n, m, k;
    private static int[][] guests;
    private static final String YES = "Yes";
    private static final String NO = "No";

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
        guests = new int[k][3];
        for (int i=0 ; i<k ; i++) {
            row = br.readLine().split(" ");
            guests[i][0] = Integer.parseInt(row[0]);
            guests[i][1] = Integer.parseInt(row[1]);
            guests[i][2] = Integer.parseInt(row[2]);
        }
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> forkUsed = new HashMap<>();
        Map<Integer, Integer> knifeUsed = new HashMap<>();
        int currentTime;
        for (int[] guest : guests) {
            currentTime = guest[0];
            for (int arrivalTime : forkUsed.keySet()) {
                if (arrivalTime > currentTime) continue;
                n += forkUsed.getOrDefault(arrivalTime, 0);
                forkUsed.put(arrivalTime, 0);
            }
            for (int arrivalTime : knifeUsed.keySet()) {
                if (arrivalTime > currentTime) continue;
                m += knifeUsed.getOrDefault(arrivalTime, 0);
                knifeUsed.put(arrivalTime, 0);
            }
            int endTime = guest[0] + guest[1];
            if (guest[2] == 0 && n > 0) {
                forkUsed.put(endTime, forkUsed.getOrDefault(endTime, 0) + 1);
                n--;
                sb.append(YES);
            } else if (guest[2] == 1 && n > 0 && m > 0) {
                forkUsed.put(endTime, forkUsed.getOrDefault(endTime, 0) + 1);
                knifeUsed.put(endTime, knifeUsed.getOrDefault(endTime, 0) + 1);
                n--;
                m--;
                sb.append(YES);
            } else {
                sb.append(NO);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}