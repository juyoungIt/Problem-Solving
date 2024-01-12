// BOJ - 1584
// Problem Sheet - https://www.acmicpc.net/problem/1584

import java.util.*;
import java.io.*;

public class Main {

    private static final int[][] map = new int[501][501];
    private static final int[][] minLose = new int[501][501];
    private static final int DANGER = 1;
    private static final int DEATH = 2;
    private static final int INFINITE = 500 * 500 + 1;
    private static final int[] xi = { -1, 1, 0, 0 };
    private static final int[] yi = { 0, 0, -1, 1 };

    static class Status implements Comparable<Status> {
        private final int x;
        private final int y;
        private final int minAccLose;

        public Status(int x, int y, int minAccLose) {
            this.x = x;
            this.y = y;
            this.minAccLose = minAccLose;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public int getMinAccLose() { return this.minAccLose; }

        @Override
        public int compareTo(Status s) {
            return this.minAccLose - s.getMinAccLose();
        }
    }

    public static void main(String[] args) throws IOException {
        setup();
        dijkstra(0, 0);
        System.out.println(minLose[500][500] == INFINITE
                ? -1
                : minLose[500][500]);
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0 ; i<=500 ; i++) {
            for(int j=0 ; j<=500 ; j++) {
                minLose[i][j] = INFINITE;
            }
        }

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i< n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            updateArea(x1, y1, x2, y2, DANGER);
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i< m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            updateArea(x1, y1, x2, y2, DEATH);
        }

        br.close();
    }

    private static void updateArea(int x1, int y1, int x2, int y2, int level) {
        int srcX = Math.min(x1, x2);
        int srcY = Math.min(y1, y2);
        int rangeX = Math.abs(x1 - x2);
        int rangeY = Math.abs(y1 - y2);
        for(int i=srcY ; i<=srcY+rangeY ; i++) {
            for(int j=srcX ; j<=srcX+rangeX ; j++) {
                map[i][j] = Math.max(map[i][j], level);
            }
        }
    }

    private static void dijkstra(int srcX, int srcY) {
        PriorityQueue<Status> pq = new PriorityQueue<>();
        pq.add(new Status(srcX, srcY, 0));
        minLose[srcY][srcX] = 0;
        while(!pq.isEmpty()) {
            Status curStatus = pq.poll();
            int curX = curStatus.getX();
            int curY = curStatus.getY();
            int curMinAccLose = curStatus.getMinAccLose();
            if(minLose[curY][curX] < curMinAccLose) continue;
            for(int i=0 ; i<4 ; i++) {
                int nextX = curX + xi[i];
                int nextY = curY + yi[i];
                if(isValid(nextX, nextY)
                        && map[nextY][nextX] != DEATH
                        && minLose[nextY][nextX] > curMinAccLose + map[nextY][nextX]) {
                    minLose[nextY][nextX] = curMinAccLose + map[nextY][nextX];
                    pq.add(new Status(nextX, nextY, minLose[nextY][nextX]));
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<=500 && y<=500;
    }
}