// BOJ - 31575
// Problem Sheet - https://www.acmicpc.net/problem/31575

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
    
    private static int n, m;
    private static int[][] map;
    private static int[] xi = { 0, 1 };
    private static int[] yi = { 1, 0 };
    private static final String YES = "Yes", NO = "No";


    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve() ? YES : NO);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[m][n];
        for (int i=0 ; i<m ; i++) {
            String[] row = br.readLine().split(" ");
            for (int j=0 ; j<n ; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }
        br.close();
    }

    private static boolean solve() {
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0));
        map[0][0] = 2;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int i=0 ; i<2 ; i++) {
                int nx = cur.getX() + xi[i];
                int ny = cur.getY() + yi[i];
                if (!isValid(nx, ny) || map[ny][nx] != 1) continue;
                queue.add(new Point(nx, ny));
                map[ny][nx] = 2;
            }
        }
        return map[m - 1][n - 1] == 2;
    }

    private static boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<n && y<m;
    }

}
