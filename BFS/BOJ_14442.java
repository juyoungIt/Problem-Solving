// BOJ - 14442
// Problem Sheet - https://www.acmicpc.net/problem/14442

import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        private final int x;
        private final int y;
        private final int brokerCount;
        private final int dist;

        public Point(int x, int y, int brokerCount, int dist) {
            this.x = x;
            this.y = y;
            this.brokerCount = brokerCount;
            this.dist = dist;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public int getBrokerCount() { return this.brokerCount; }
        public int getDist() { return this.dist; }
    }

    private static int N, M, K;
    private static boolean[][] map;
    private static boolean[][][] visitedTimes;

    private static final int[] xi = { -1, 1, 0, 0 };
    private static final int[] yi = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        map = new boolean[N][M];
        visitedTimes = new boolean[N][M][K + 1];
        for (int i=0 ; i<N ; i++) {
            String row = br.readLine();
            for (int j=0 ; j<M ; j++) {
                map[i][j] = row.charAt(j) == '0';
            }
        }
        br.close();
    }

    private static int solve() {
        int dist = -1;
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0, 0, 1));
        visitedTimes[0][0][0] = true;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (cur.getX() == M-1 && cur.getY() == N-1) {
                dist = cur.getDist();
                break;
            }
            for (int i=0 ; i<4 ; i++) {
                int nx = cur.getX() + xi[i];
                int ny = cur.getY() + yi[i];
                if (isNotValid(nx, ny)) continue;
                if (visitedTimes[ny][nx][cur.getBrokerCount()]) continue;
                if (map[ny][nx]) {
                    queue.add(new Point(nx, ny, cur.getBrokerCount(), cur.getDist() + 1));
                    visitedTimes[ny][nx][cur.getBrokerCount()] = true;
                } else if (cur.getBrokerCount() < K && !visitedTimes[ny][nx][cur.getBrokerCount() + 1]) {
                    queue.add(new Point(nx, ny, cur.getBrokerCount() + 1, cur.getDist() + 1));
                    visitedTimes[ny][nx][cur.getBrokerCount() + 1] = true;
                }
            }
        }
        return dist;
    }

    private static boolean isNotValid(int x, int y) {
        return !(x>=0 && y>=0 && x<M && y<N);
    }
}