// BOJ - 1916
// Problem Sheet - https://www.acmicpc.net/problem/1916

import java.util.*;
import java.io.*;

public class Main {

    static final int INF = 100_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] costs = new int[n + 1];
        boolean[] isFinished = new boolean[n + 1];
        int[][] am = new int[n + 1][n + 1];
        Arrays.fill(costs, INF);
        for (int i=1 ; i<=n ; i++) {
            Arrays.fill(am[i], INF);
        }
        for (int i=0 ; i<m ; i++) {
            String[] row = br.readLine().split(" ");
            int dept = Integer.parseInt(row[0]);
            int dest = Integer.parseInt(row[1]);
            int cost = Integer.parseInt(row[2]);
            am[dept][dest] = Math.min(am[dept][dest], cost);
        }
        String[] row = br.readLine().split(" ");
        int dept = Integer.parseInt(row[0]);
        int dest = Integer.parseInt(row[1]);

        costs[dept] = 0;
        for (int i=1 ; i<=n ; i++) {
            int minCost = INF;
            int minIndex = -1;
            for (int j=1 ; j<=n ; j++) {
                if (costs[j] < minCost && !isFinished[j]) {
                    minCost = costs[j];
                    minIndex = j;
                }
            }
            if (minIndex == -1) break;
            for (int j=1 ; j<=n ; j++) {
                costs[j] = Math.min(costs[j], costs[minIndex] + am[minIndex][j]);
            }
            isFinished[minIndex] = true;
        }

        System.out.println(costs[dest]);
        br.close();
    }

}