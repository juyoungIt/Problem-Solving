// BOJ - 7569
// Problem Sheet - https://www.acmicpc.net/problem/7569

import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        private final int x;
        private final int y;
        private final int z;
        private final int day;

        public Point(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public int getZ() { return this.z; }
        public int getDay() { return this.day; }
    }

    private static int M, N, H;
    private static int[][][] box;
    private static int unripeCount = 0;

    private static final Queue<Point> queue = new ArrayDeque<>();
    private static final int[] xi = { -1, 1, 0, 0, 0, 0 };
    private static final int[] yi = { 0, 0, -1, 1, 0, 0 };
    private static final int[] zi = { 0, 0, 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        H = Integer.parseInt(input[2]);
        box = new int[H][N][M];
        for (int i=0 ; i<H ; i++) {
            for (int j=0 ; j<N ; j++) {
                String[] row = br.readLine().split(" ");
                for (int k=0 ; k<M ; k++) {
                    box[i][j][k] = Integer.parseInt(row[k]);
                    if (box[i][j][k] == 0) {
                        unripeCount++;
                    } else if (box[i][j][k] == 1) {
                        queue.add(new Point(k, j, i, 0));
                        box[i][j][k] = 1;
                    }
                }
            }
        }
        br.close();
    }

    private static int solve() {
        int day = -1;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (unripeCount == 0) {
                day = cur.getDay();
            }
            for (int i=0 ; i<6 ; i++) {
                int nx = cur.getX() + xi[i];
                int ny = cur.getY() + yi[i];
                int nz = cur.getZ() + zi[i];
                if (isOutOfRange(nx, ny, nz) || box[nz][ny][nx] != 0) continue;
                queue.add(new Point(nx, ny, nz, cur.getDay() + 1));
                box[nz][ny][nx] = 1;
                unripeCount--;
            }
        }
        return day;
    }

    private static boolean isOutOfRange(int x, int y, int z) {
        return !(x>=0 && y>=0 && z>=0 && x<M && y<N && z<H);
    }
}