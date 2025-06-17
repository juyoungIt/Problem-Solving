// BOJ - 6186
// Problem Sheet - https://www.acmicpc.net/problem/6186

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
    
    private static int r, c;
    private static int[][] field;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        field = new int[r][c];
        for (int i=0 ; i<r ; i++) {
            String row = br.readLine();
            for (int j=0 ; j<c ; j++) {
                if (row.charAt(j) == '#') field[i][j] = 1;
                else field[i][j] = 0;
            }
        }
        br.close();
    }

    private static int solve() {
        int count = 0;
        for (int i=0 ; i<r ; i++) {
            for (int j=0 ; j<c ; j++) {
                if (field[i][j] != 1) continue;
                bfs(j, i);
                count++;
            }
        }
        return count;
    }

    private static void bfs(int sx, int sy) {
        int[] xi = { -1, 1, 0, 0 };
        int[] yi = { 0, 0, -1, 1 };
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(sx, sy));
        field[sy][sx] = 2;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int i=0 ; i<4 ; i++) {
                int nx = cur.getX() + xi[i];
                int ny = cur.getY() + yi[i];
                if (isNotValid(nx, ny) || field[ny][nx] != 1) continue;
                queue.add(new Point(nx, ny));
                field[ny][nx] = 2;
            }
        }
    }

    private static boolean isNotValid(int x, int y) {
        return !(x>=0 && y>=0 && x<c && y<r);
    }

}
