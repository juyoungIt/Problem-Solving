// BOJ - 3055
// Problem Sheet - https://www.acmicpc.net/problem/3055

import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
    }

    private static int R, C;
    private static char[][] map;
    private static int[][] floods;
    private static int[][] escapes;

    private static final Queue<Point> waterQueue = new ArrayDeque<>();
    private static final Queue<Point> escapeQueue = new ArrayDeque<>();
    private static final int[] xi = { -1, 1, 0, 0 };
    private static final int[] yi = { 0, 0, -1, 1 };
    private static final String FAILED = "KAKTUS";

    public static void main(String[] args) throws IOException {
        input();
        int escapeTime = solve();
        System.out.println(escapeTime >= 0 ? escapeTime : FAILED);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        map = new char[R][C];
        floods = new int[R][C];
        escapes = new int[R][C];
        for (int i=0 ; i<R ; i++) {
            String row = br.readLine();
            for (int j=0 ; j<C ; j++) {
                map[i][j] = row.charAt(j);
                if (map[i][j] == 'S') {
                    escapeQueue.add(new Point(j, i));
                } else if (map[i][j] == '*') {
                    waterQueue.add(new Point(j, i));
                }
            }
        }
        br.close();
    }

    private static int solve() {
        floods();
        return escape();
    }

    private static void floods() {
        while (!waterQueue.isEmpty()) {
            Point cur = waterQueue.poll();
            for (int i=0 ; i<4 ; i++) {
                int nx = cur.getX() + xi[i];
                int ny = cur.getY() + yi[i];
                if (isOutOfRange(nx, ny) || map[ny][nx] != '.' || floods[ny][nx] > 0) continue;
                waterQueue.add(new Point(nx, ny));
                floods[ny][nx] = floods[cur.getY()][cur.getX()] + 1;
            }
        }
    }

    private static int escape() {
        int time = -1;
        while (!escapeQueue.isEmpty()) {
            Point cur = escapeQueue.poll();
            if (map[cur.getY()][cur.getX()] == 'D') {
                time = escapes[cur.getY()][cur.getX()];
                break;
            }
            for (int i=0 ; i<4 ; i++) {
                int nx = cur.getX() + xi[i];
                int ny = cur.getY() + yi[i];
                if (isOutOfRange(nx, ny) || map[ny][nx] == 'X' || escapes[ny][nx] > 0) continue;
                if (floods[ny][nx] != 0 && floods[ny][nx] <= escapes[cur.getY()][cur.getX()] + 1) continue;
                escapeQueue.add(new Point(nx, ny));
                escapes[ny][nx] = escapes[cur.getY()][cur.getX()] + 1;
            }
        }
        return time;
    }

    private static boolean isOutOfRange(int x, int y) {
        return !(x>=0 && y>=0 && x<C && y<R);
    }
}