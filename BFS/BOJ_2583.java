// BOJ - 2583
// Problem Sheet - https://www.acmicpc.net/problem/2583

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

    private static int M, N, K;
    private static int[][] paper;
    private static boolean[][] visited;

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
        K = Integer.parseInt(row[2]);
        paper = new int[M][N];
        visited = new boolean[M][N];
        for (int i=0 ; i<K ; i++) {
            row = br.readLine().split(" ");
            int ltx = Integer.parseInt(row[0]);
            int lty = Integer.parseInt(row[1]);
            int rbx = Integer.parseInt(row[2]);
            int rby = Integer.parseInt(row[3]);
            drawRect(ltx, lty, rbx, rby);
        }
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        List<Integer> areas = new ArrayList<>();
        for (int i=0 ; i<M ; i++) {
            for (int j=0 ; j<N ; j++) {
                if (paper[i][j] == 1 || visited[i][j]) continue;
                areas.add(bfs(j, i));
            }
        }
        Collections.sort(areas);

        sb.append(areas.size()).append("\n");
        for (int area : areas) {
            sb.append(area).append(" ");
        }
        return sb.toString();
    }

    private static int bfs(int sx, int sy) {
        int area = 0;
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(sx, sy));
        visited[sy][sx] = true;
        area++;
        while (!queue.isEmpty()) {
            for (int i=0 ; i<4 ; i++) {
                int nx = queue.peek().getX() + xi[i];
                int ny = queue.peek().getY() + yi[i];
                if (isNotValid(nx, ny) || visited[ny][nx] || paper[ny][nx] == 1) continue;
                queue.add(new Point(nx, ny));
                visited[ny][nx] = true;
                area++;
            }
            queue.poll();
        }
        return area;
    }

    private static void drawRect(int ltx, int lty, int rbx, int rby) {
        for (int i=lty ; i<rby ; i++) {
            for (int j=ltx ; j<rbx ; j++) {
                paper[i][j] = 1;
            }
        }
    }

    private static boolean isNotValid(int x, int y) {
        return !(x>=0 && y>=0 && x<N && y<M);
    }
}