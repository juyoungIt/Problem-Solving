// BOJ - 2636
// Problem Sheet - https://www.acmicpc.net/problem/2636

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

    private static int N, M;
    private static boolean[][] board;
    private static int cheeseArea = 0;

    private static final int[] xi = { -1, 1, 0, 0 };
    private static final int[] yi = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        N = Integer.parseInt(row[0]);
        M = Integer.parseInt(row[1]);
        board = new boolean[N][M];
        for (int i=0 ; i<N ; i++) {
            row = br.readLine().split(" ");
            for (int j=0 ; j<M ; j++) {
                board[i][j] = Integer.parseInt(row[j]) == 1;
                if (board[i][j]) cheeseArea++;
            }
        }
        br.close();
    }

    private static String solve() {
        int time = 0, lastMeltedCount = 0;
        while (cheeseArea > 0) {
            time++;
            lastMeltedCount = bfs();
            cheeseArea -= lastMeltedCount;
        }
        return time + "\n" + lastMeltedCount;
    }

    private static int bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        List<Point> melted = new ArrayList<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new Point(0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int i=0 ; i<4 ; i++) {
                int nx = cur.getX() + xi[i];
                int ny = cur.getY() + yi[i];
                if (isOutOfRange(nx, ny) || visited[ny][nx]) continue;
                if (board[ny][nx]) melted.add(new Point(nx, ny));
                else queue.add(new Point(nx, ny));
                visited[ny][nx] = true;
            }
        }
        for (Point point : melted) {
            board[point.getY()][point.getX()] = false;
        }
        return melted.size();
    }

    private static boolean isOutOfRange(int x, int y) {
        return !(x>=0 && y>=0 && x<M && y<N);
    }

}