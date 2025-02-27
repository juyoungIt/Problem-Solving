// BOJ - 2667
// Problem Sheet - https://www.acmicpc.net/problem/2667

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

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private static int N;
    private static int[][] map;
    private static final List<Point> points = new ArrayList<>();
    private static final int[] xi = { -1, 1, 0, 0 };
    private static final int[] yi = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i=0 ; i<N ; i++) {
            String[] row = br.readLine().split("");
            for (int j=0 ; j<N ; j++) {
                map[i][j] = Integer.parseInt(row[j]);
                if (map[i][j] == 1) {
                    points.add(new Point(j, i));
                }
            }
        }
        br.close();
    }

    private static String solve() {
        List<Integer> sizes = new ArrayList<>();
        for (Point point : points) {
            int size = dfs(point.getX(), point.getY());
            if (size > 0) {
                sizes.add(size);
            }
        }
        Collections.sort(sizes);
        StringBuilder sb = new StringBuilder();
        sb.append(sizes.size()).append("\n");
        for (int size : sizes) {
            sb.append(size).append("\n");
        }
        return sb.toString();
    }

    private static int dfs(int sx, int sy) {
        if (map[sy][sx] == 2) return 0;
        Deque<Point> stack = new ArrayDeque<>();
        int size = 0;
        stack.push(new Point(sx, sy));
        map[sy][sx] = 2;
        size++;
        while (!stack.isEmpty()) {
            boolean allConnected = true;
            for (int i=0 ; i<4 ; i++) {
                int nx = stack.peek().getX() + xi[i];
                int ny = stack.peek().getY() + yi[i];
                if (isNotValid(nx, ny) || map[ny][nx] == 2 || map[ny][nx] == 0) continue;
                stack.push(new Point(nx, ny));
                map[ny][nx] = 2;
                size++;
                allConnected = false;
                break;
            }
            if (allConnected) stack.pop();
        }
        return size;
    }

    private static boolean isNotValid(int x, int y) {
        return !(x>=0 && y>=0 && x<N && y<N);
    }
}