// BOJ - 4485
// Problem Sheet - https://www.acmicpc.net/problem/4485

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[][] map;
    private static int[][] minCost;
    private static final int[] xi = {-1, 1, 0, 0};
    private static final int[] yi = {0, 0, -1, 1};
    private static final String OUTPUT_FORMAT  = "Problem %d: %d\n";

    static class Status implements Comparable<Status> {
        private final int x;
        private final int y;
        private final int cost;

        public Status(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public int getCost() { return this.cost; }

        @Override
        public int compareTo(Status s) {
            return this.cost - s.getCost();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int seq = 1;
        while(true) {
            n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            map = new int[n][n];
            minCost = new int[n][n];
            for(int i=0 ; i<n ; i++) {
                String[] row = br.readLine().split(" ");
                for(int j=0 ; j<n ; j++) {
                    map[i][j] = Integer.parseInt(row[j]);
                    minCost[i][j] = 129 * 129 * 9 + 1;
                }
            }
            dijkstra();
            sb.append(String.format(OUTPUT_FORMAT, seq++, minCost[n-1][n-1]));
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static void dijkstra() {
        PriorityQueue<Status> pq = new PriorityQueue<>();
        boolean[][] isVisit = new boolean[n][n];

        pq.add(new Status(0, 0, map[0][0]));
        isVisit[0][0] = true;
        while(!pq.isEmpty()) {
            Status curStatus = pq.poll();
            int curX = curStatus.getX();
            int curY = curStatus.getY();
            int curCost = curStatus.getCost();
            for(int i=0 ; i<4 ; i++) {
                int nextX = curX + xi[i];
                int nextY = curY + yi[i];
                if(isValid(nextX, nextY)
                        && !isVisit[nextY][nextX]
                        && minCost[nextY][nextX] > curCost + map[nextY][nextX]) {
                    isVisit[nextY][nextX] = true;
                    minCost[nextY][nextX] = curCost + map[nextY][nextX];
                    pq.add(new Status(nextX, nextY, curCost + map[nextY][nextX]));
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<n && y<n;
    }
}