// BOJ - 11909
// Problem Sheet - https://www.acmicpc.net/problem/11909

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[][] map;
    private static int[][] minCost;
    private static final int INFINITE = Integer.MAX_VALUE;
    private static final int[] xi = { 1, 0 };
    private static final int[] yi = { 0, 1 };

    static class Status implements Comparable<Status> {
        private final int x;
        private final int y;
        private final int optCost;

        public Status(int x, int y, int optCost) {
            this.x = x;
            this.y = y;
            this.optCost = optCost;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public int getOptCost() { return this.optCost; }

        @Override
        public int compareTo(Status s) {
            return this.optCost - s.getOptCost();
        }
    }

    public static void main(String[] args) throws IOException {
        setup();
        dijkstra();
        System.out.println(minCost[n][n]);
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        minCost = new int[n + 1][n + 1];
        for(int i=1 ; i<=n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1 ; j<=n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                minCost[i][j] = INFINITE;
            }
        }

        br.close();
    }

    private static void dijkstra() {
        PriorityQueue<Status> pq = new PriorityQueue<>();
        pq.add(new Status(1, 1, 0));
        minCost[1][1] = 0;
        while(!pq.isEmpty()) {
            Status curStatus = pq.poll();
            int curX = curStatus.getX();
            int curY = curStatus.getY();
            int curOptCost = curStatus.getOptCost();
            if(minCost[curY][curX] < curOptCost) continue;
            for(int i=0 ; i<2 ; i++) {
                int nextX = curX + xi[i];
                int nextY = curY + yi[i];
                if(!isValid(nextX, nextY)) continue;
                int nextCost = curOptCost + getAdditionalCost(curX, curY, nextX, nextY);
                if(minCost[nextY][nextX] > nextCost) {
                    minCost[nextY][nextX] = nextCost;
                    pq.add(new Status(nextX, nextY, nextCost));
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x>0 && y>0 && x<=n && y<=n;
    }

    private static int getAdditionalCost(int curX, int curY, int nextX, int nextY) {
        return (map[curY][curX] <= map[nextY][nextX])
                ? map[nextY][nextX] - map[curY][curX] + 1
                : 0;
    }
}