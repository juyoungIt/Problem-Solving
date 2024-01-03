// BOJ - 14497
// Problem Sheet - https://www.acmicpc.net/problem/14497

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int m;
    private static int x1;
    private static int y1;
    private static int x2;
    private static int y2;
    private static char[][] map;
    private static int[][] optJumpCnt;
    private static final int[] xi = { -1, 1, 0, 0 };
    private static final int[] yi = { 0, 0, -1, 1 };

    static class Status implements Comparable<Status> {
        private final int x;
        private final int y;
        private final int minJumpCnt;

        public Status(int x, int y, int minJumpCnt) {
            this.x = x;
            this.y = y;
            this.minJumpCnt = minJumpCnt;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public int getMinJumpCnt() { return this.minJumpCnt; }


        @Override
        public int compareTo(Status s) {
            return this.minJumpCnt - s.getMinJumpCnt();
        }
    }

    public static void main(String[] args) throws IOException {
        setup();
        dijkstra(x1, y1);
        System.out.println(optJumpCnt[x2][y2]);
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        map = new char[n + 1][m + 1];
        optJumpCnt = new int[n + 1][m + 1];
        for(int i=1 ; i<=n ; i++) {
            char[] row = br.readLine().toCharArray();
            for(int j=1 ; j<=m ; j++) {
                map[i][j] = row[j-1];
                optJumpCnt[i][j] = n * m + 1;
            }
        }

        br.close();
    }

    private static void dijkstra(int srcX, int srcY) {
        PriorityQueue<Status> pq = new PriorityQueue<>();
        pq.add(new Status(srcX, srcY, 0));
        while(!pq.isEmpty()) {
            Status curStatus = pq.poll();
            int curX = curStatus.getX();
            int curY = curStatus.getY();
            int curMinJumpCnt = curStatus.getMinJumpCnt();
            if(optJumpCnt[curX][curY] < curMinJumpCnt) continue;
            for(int i=0 ; i<4 ; i++) {
                int nextX = curX + xi[i];
                int nextY = curY + yi[i];
                if(isValid(nextX, nextY)
                        && optJumpCnt[nextX][nextY] > curMinJumpCnt + (map[nextX][nextY] == '1' || map[nextX][nextY] == '#' ? 1 : 0)) {
                    optJumpCnt[nextX][nextY] = curMinJumpCnt + (map[nextX][nextY] == '1' || map[nextX][nextY] == '#' ? 1 : 0);
                    pq.add(new Status(nextX, nextY, optJumpCnt[nextX][nextY]));
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x>0 && y>0 && x<=n && y<=m;
    }
}