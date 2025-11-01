// BOJ - 34238
// Problem Sheet - https://www.acmicpc.net/problem/34238

import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
    }

    private static final int[] xi = { 0, 1, 1, 1, 0, -1, -1, -1 };
    private static final int[] yi = { -1, -1, 0, 1, 1, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];
        List<Point> points = new ArrayList<>();
        for (int i=0 ; i<n ; i++) {
            String row = br.readLine();
            for (int j=0 ; j<m ; j++) {
                char c = row.charAt(j);
                board[i][j] = c;
                if (c == 'F') points.add(new Point(j, i));
            }
        }

        int count = 0;
        for (Point point : points) {
            int curX = point.getX();
            int curY = point.getY();
            for (int i=0 ; i<8 ; i++) {
                int nextX = curX + xi[i];
                int nextY = curY + yi[i];
                if (!isValid(nextX, nextY, m, n)) continue;
                if (board[nextY][nextX] != 'O') continue;
                nextX = nextX + xi[i];
                nextY = nextY + yi[i];
                if (!isValid(nextX, nextY, m, n)) continue;
                if (board[nextY][nextX] != 'X') continue;
                count++;
            }
        }

        System.out.println(count);
        br.close();
    }

    private static boolean isValid(int x, int y, int m, int n) {
        return x>=0 && x<m && y>=0 && y<n;
    }
}
