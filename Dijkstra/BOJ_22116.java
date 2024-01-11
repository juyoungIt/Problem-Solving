// BOJ - 22116
// Problem Sheet - https://www.acmicpc.net/problem/22116

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[][] map;
    private static int[][] minCost;
    private static final int[] xi = { -1, 1, 0, 0 };
    private static final int[] yi = { 0, 0, -1, 1 };
    private static final int INFINITE = 1_000_000_001;

    static class Status implements Comparable<Status> {
        private final int x;
        private final int y;
        private final int diff;

        public Status(int x, int y, int diff) {
            this.x = x;
            this.y = y;
            this.diff = diff;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public int getDiff() { return this.diff; }

        @Override
        public int compareTo(Status s) {
            return this.diff - s.getDiff();
        }
    }

    public static void main(String[] args) throws IOException {
        setup();
        dijkstra();
        System.out.println(n == 1 ? 0 : minCost[n][n]);
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
        while(!pq.isEmpty()) {
            Status curStatus = pq.poll();
            int curX = curStatus.getX();
            int curY = curStatus.getY();
            int curDiff = curStatus.getDiff();
            if(minCost[curY][curX] < curDiff) continue;
            for(int i=0 ; i<4 ; i++) {
                int nextX = curX + xi[i];
                int nextY = curY + yi[i];
                if(!isValid(nextX, nextY)) continue;
                int nextDiff = Math.max(Math.abs(map[curY][curX] - map[nextY][nextX]), curDiff);
                if(minCost[nextY][nextX] > nextDiff) {
                    minCost[nextY][nextX] = nextDiff;
                    pq.add(new Status(nextX, nextY, nextDiff));
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x>0 && y>0 && x<=n && y<=n;
    }
}