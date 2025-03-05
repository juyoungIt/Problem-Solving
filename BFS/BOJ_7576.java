// BOJ - 7576
// Problem Sheet - https://www.acmicpc.net/problem/7576

import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        private final int x;
        private final int y;
        private final int days;

        public Point(int x, int y, int days) {
            this.x = x;
            this.y = y;
            this.days = days;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public int getDays() { return this.days; }
    }

    private static int M, N;
    private static int[][] box;
    private static int unripeTomatoCount = 0;

    private static final Queue<Point> queue = new ArrayDeque<>();
    private static final int[] xi = { -1, 1, 0, 0 };
    private static final int[] yi = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        M = Integer.parseInt(row[0]);
        N = Integer.parseInt(row[1]);
        box = new int[N][M];
        for (int i=0 ; i<N ; i++) {
            row = br.readLine().split(" ");
            for (int j=0 ; j<M ; j++) {
                box[i][j] = Integer.parseInt(row[j]);
                if (box[i][j] == 1) {
                    queue.add(new Point(j, i, 0));
                } else if (box[i][j] == 0) {
                    unripeTomatoCount++;
                }
            }
        }
        br.close();
    }

    private static int solve() {
        int days = -1;
        while (!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            int curDay = queue.peek().getDays();
            if (unripeTomatoCount == 0) {
                days = curDay;
            }
            for (int i=0 ; i<4 ; i++) {
                int newX = curX + xi[i];
                int newY = curY + yi[i];
                if (isNotValid(newX, newY) || box[newY][newX] != 0) continue;
                queue.add(new Point(newX, newY, curDay + 1));
                box[newY][newX] = 1;
                unripeTomatoCount--;
            }
            queue.poll();
        }
        return days;
    }

    private static boolean isNotValid(int x, int y) {
        return !(x>=0 && y>=0 && x<M && y<N);
    }
}