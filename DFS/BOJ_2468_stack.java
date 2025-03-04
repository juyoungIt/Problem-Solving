// BOJ - 2468
// Problem Sheet - https://www.acmicpc.net/problem/2468

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

    private static int N;
    private static int[][] land;
    private static boolean[][] visited;
    private static int maxHeight = 0;

    private static final int[] xi = { -1, 1, 0, 0 };
    private static final int[] yi = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        land = new int[N][N];
        visited = new boolean[N][N];
        for (int i=0 ; i<N ; i++) {
            String[] row = br.readLine().split(" ");
            for (int j=0 ; j<N ; j++) {
                land[i][j] = Integer.parseInt(row[j]);
                maxHeight = Math.max(maxHeight, land[i][j]);
            }
        }
        br.close();
    }

    private static int solve() {
        int maxSafeAreaCount = 0;
        for (int h=0 ; h<=maxHeight ; h++) {
            int safeAreaCount = 0;
            visited = new boolean[N][N];
            for (int i=0 ; i<N ; i++) {
                for (int j=0 ; j<N ; j++) {
                    if (visited[i][j] || land[i][j] <= h) continue;
                    dfs(j, i, h);
                    safeAreaCount++;
                }
            }
            maxSafeAreaCount = Math.max(maxSafeAreaCount, safeAreaCount);
        }
        return maxSafeAreaCount;
    }

    private static void dfs(int sx, int sy, int h) {
        Deque<Point> stack = new ArrayDeque<>();
        stack.push(new Point(sx, sy));
        visited[sy][sx] = true;
        while (!stack.isEmpty()) {
            boolean allConnected = true;
            for (int i=0 ; i<4 ; i++) {
                int nx = stack.peek().getX() + xi[i];
                int ny = stack.peek().getY() + yi[i];
                if (isNotValid(nx, ny) || visited[ny][nx] || land[ny][nx] <= h) continue;
                stack.push(new Point(nx, ny));
                visited[ny][nx] = true;
                allConnected = false;
                break;
            }
            if (allConnected) stack.pop();
        }
    }

    private static boolean isNotValid(int x, int y) {
        return !(x>=0 && y>=0 && x<N && y<N);
    }

}