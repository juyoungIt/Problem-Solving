// BOJ - 2206
// Problem Sheet - https://www.acmicpc.net/problem/2206

import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        private final int x;
        private final int y;
        private final int useBroker;
        private final int dist;

        public Point(int x, int y, int useBroker, int dist) {
            this.x = x;
            this.y = y;
            this.useBroker = useBroker;
            this.dist = dist;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public int isBrokerUsed() { return this.useBroker; }
        public int getDist() { return this.dist; }
    }

    private static int N, M;
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
        map = new boolean[N][M];
        visitedTimes = new boolean[N][M][2];
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
                if (visitedTimes[ny][nx][cur.isBrokerUsed()]) continue;
                if (map[ny][nx]) {
                    queue.add(new Point(nx, ny, cur.isBrokerUsed(), cur.getDist() + 1));
                    visitedTimes[ny][nx][cur.isBrokerUsed()] = true;
                } else if (cur.isBrokerUsed() == 0) {
                    queue.add(new Point(nx, ny, 1, cur.getDist() + 1));
                    visitedTimes[ny][nx][1] = true;
                }
            }
        }
        return dist;
    }

    private static boolean isNotValid(int x, int y) {
        return !(x>=0 && y>=0 && x<M && y<N);
    }
}