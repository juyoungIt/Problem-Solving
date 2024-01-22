// BOJ - 20046
// Problem Sheet - https://www.acmicpc.net/problem/20046

import java.util.*;
import java.io.*;

public class Main {

    private static int m;
    private static int n;
    private static int[][] map;
    private static int[][] optCostMap;
    private static boolean[][] isVisit;
    private static final int INFINITE = 1_000 * 1_000 * 2 + 1;
    private static final int[] XI = { -1, 1, 0, 0 };
    private static final int[] YI = { 0, 0, -1, 1 };

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
        dijkstra(0, 0);
        System.out.println(optCostMap[m-1][n-1] < INFINITE ? optCostMap[m-1][n-1] : -1);
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        optCostMap = new int[m][n];
        isVisit = new boolean[m][n];
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(optCostMap[i], INFINITE);
            for(int j=0 ; j<n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();
    }

    private static void dijkstra(int srcX, int srcY) {
        if(map[srcY][srcX] == -1) return;
        PriorityQueue<Status> pq = new PriorityQueue<>();
        pq.add(new Status(srcX, srcY, map[srcY][srcX]));
        optCostMap[srcY][srcX] = map[srcY][srcX];
        isVisit[srcY][srcX] = true;
        while(!pq.isEmpty()) {
            Status curStatus = pq.poll();
            int curX = curStatus.getX();
            int curY = curStatus.getY();
            int curOptCost = curStatus.getOptCost();
            for(int i=0 ; i<4 ; i++) {
                int nextX = curX + XI[i];
                int nextY = curY + YI[i];
                if(isValid(nextX, nextY)
                        && !isVisit[nextY][nextX]
                        && map[nextY][nextX] >= 0
                        && optCostMap[nextY][nextX] > curOptCost + map[nextY][nextX]) {
                    pq.add(new Status(nextX, nextY, curOptCost + map[nextY][nextX]));
                    optCostMap[nextY][nextX] = curOptCost + map[nextY][nextX];
                    isVisit[nextY][nextX] = true;
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<n && y<m;
    }
}