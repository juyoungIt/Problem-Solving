// BOJ - 2665
// Problem Sheet - https://www.acmicpc.net/problem/2665

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[][] map;
    private static int[][] minBreakingCnt;
    private static final int[] xi = { -1, 1, 0, 0 };
    private static final int[] yi = { 0, 0, -1, 1 };

    static class Info implements Comparable<Info> {
        private final int x;
        private final int y;
        private final int breakingCnt;

        public Info(int x, int y, int breakingCnt) {
            this.x = x;
            this.y = y;
            this.breakingCnt = breakingCnt;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public int getBreakingCnt() { return this.breakingCnt; }

        @Override
        public int compareTo(Info i) {
            return this.breakingCnt - i.getBreakingCnt();
        }
    }

    public static void main(String[] args) throws IOException {
        setup();
        dijkstra();
        System.out.println(minBreakingCnt[n-1][n-1]);
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        minBreakingCnt = new int[n][n];
        for(int i=0 ; i<n ; i++) {
            String[] row = br.readLine().split("");
            for(int j=0 ; j<n ; j++) {
                map[i][j] = Integer.parseInt(row[j]);
                minBreakingCnt[i][j] = n * n + 1;
            }
        }
        br.close();
    }

    private static void dijkstra() {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(0, 0, 0));
        while(!pq.isEmpty()) {
            Info curInfo = pq.poll();
            int curX = curInfo.getX();
            int curY = curInfo.getY();
            int curBreakingCnt = curInfo.getBreakingCnt();
            for(int i=0 ; i<4 ; i++) {
                int nextX = curX + xi[i];
                int nextY = curY + yi[i];
                if(isValid(nextX, nextY, n)
                        && minBreakingCnt[nextY][nextX] > curBreakingCnt + (map[nextY][nextX] == 1 ? 0 : 1)) {
                    minBreakingCnt[nextY][nextX] = curBreakingCnt + (map[nextY][nextX] == 1 ? 0 : 1);
                    pq.add(new Info(nextX, nextY, minBreakingCnt[nextY][nextX]));
                }
            }
        }
    }

    private static boolean isValid(int x, int y, int n) {
        return x>=0 && y>=0 && x<n && y<n;
    }
}