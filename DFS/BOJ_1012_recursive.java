// BOJ - 1012
// Problem Sheet - https://www.acmicpc.net/problem/1012

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

    private static int T, N, M, K;
    private static int[][] land;

    private static final int[] xi = { -1, 1, 0, 0 };
    private static final int[] yi = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] row = br.readLine().split(" ");
            N = Integer.parseInt(row[0]);
            M = Integer.parseInt(row[1]);
            K = Integer.parseInt(row[2]);
            land = new int[M][N];
            List<Point> points = new ArrayList<>(K);
            for (int i=0 ; i<K ; i++) {
                row = br.readLine().split(" ");
                int X = Integer.parseInt(row[0]);
                int Y = Integer.parseInt(row[1]);
                land[Y][X] = 1;
                points.add(new Point(X, Y));
            }

            int count = 0;
            for (Point point : points) {
                if (!dfs(point)) continue;
                count++;
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static boolean dfs(Point point) {
        if (land[point.getY()][point.getX()] == 2) return false;
        land[point.getY()][point.getX()] = 2;
        for (int i=0 ; i<4 ; i++) {
            int nx = point.getX() + xi[i];
            int ny = point.getY() + yi[i];
            if (isNotValid(nx, ny) || land[ny][nx] == 2 || land[ny][nx] == 0) continue;
            dfs(new Point(nx, ny));
        }
        return true;
    }

    private static boolean isNotValid(int x, int y) {
        return !(x>=0 && y>=0 && x<N && y<M);
    }
}