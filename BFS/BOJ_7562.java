// BOJ - 7562
// Problem Sheet - https://www.acmicpc.net/problem/7562

import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        private final int x;
        private final int y;
        private final int dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public int getDist() { return this.dist; }
    }

    private static final int[] xi = { -2, -1, 1, 2, 2, 1, -1, -2 };
    private static final int[] yi = { -1, -2, -2, -1, 1, 2, 2, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int l = Integer.parseInt(br.readLine());
            String[] row = br.readLine().split(" ");
            int sx = Integer.parseInt(row[0]);
            int sy = Integer.parseInt(row[1]);
            row = br.readLine().split(" ");
            int dx = Integer.parseInt(row[0]);
            int dy = Integer.parseInt(row[1]);
            sb.append(getShortestDist(l, sx, sy, dx, dy)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int getShortestDist(int l, int sx, int sy, int dx, int dy) {
        int dist = 0;
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[l][l];
        queue.add(new Point(sx, sy, 0));
        visited[sy][sx] = true;
        while (!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            int curDist = queue.peek().getDist();
            if (curX == dx && curY == dy) {
                dist = curDist;
                break;
            }
            for (int i=0 ; i<8 ; i++) {
                int newX = curX + xi[i];
                int newY = curY + yi[i];
                if (isNotValid(l, newX, newY) || visited[newY][newX]) continue;
                queue.add(new Point(newX, newY, curDist + 1));
                visited[newY][newX] = true;
            }
            queue.poll();
        }
        return dist;
    }

    private static boolean isNotValid(int l, int x, int y) {
        return !(x>=0 && y>=0 && x<l && y<l);
    }
}