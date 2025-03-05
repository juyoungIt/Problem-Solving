// BOJ - 2178
// Problem Sheet - https://www.acmicpc.net/problem/2178

import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        private final int x;
        private final int y;
        private final int depth;

        public Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public int getDepth() { return this.depth; }
    }

    private static int N, M;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        N = Integer.parseInt(row[0]);
        M = Integer.parseInt(row[1]);
        map = new int[N][M];
        for (int i=0 ; i<N ; i++) {
            row = br.readLine().split("");
            for (int j=0 ; j<M ; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }
        br.close();
    }

    private static int solve() {
        int dist = 0;
        Queue<Point> queue = new ArrayDeque<>();
        int[] xi = { -1, 1, 0, 0 };
        int[] yi = { 0, 0, -1, 1 };
        queue.add(new Point(0, 0, 1));
        map[0][0] = 2;
        while (!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            int curDepth = queue.peek().getDepth();
            if (curX == M-1 && curY == N-1) {
                dist = curDepth;
                break;
            }
            for (int i=0 ; i<4 ; i++) {
                int newX = curX + xi[i];
                int newY = curY + yi[i];
                if (isNotValid(newX, newY) || map[newY][newX] != 1) continue;
                queue.add(new Point(newX, newY, curDepth + 1));
                map[newY][newX] = 2;
            }
            queue.poll();
        }
        return dist;
    }

    private static boolean isNotValid(int x, int y) {
        return !(x>=0 && y>=0 && x<M && y<N);
    }
}