// BOJ - 11260
// Problem Sheet - https://www.acmicpc.net/problem/11260

import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int r, c;
    private static char[][] board;
    private static final int[] xi = { 0, 1, 1, 1, 0, -1, -1, -1 };
    private static final int[] yi = { -1, -1, 0, 1, 1, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (r == 0 && c == 0) break;
            board = new char[r][c];
            Queue<Point> queue = new LinkedList<>();
            for (int i=0 ; i<r ; i++) {
                String row = br.readLine();
                for (int j=0 ; j<c ; j++) {
                    board[i][j] = row.charAt(j);
                    if (board[i][j] == '#') {
                        queue.add(new Point(i, j));
                    }
                }
            }
            int count = 0;
            while (!queue.isEmpty()) {
                Point cur = queue.poll();
                if (isCancer(cur.c, cur.r)) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static boolean isCancer(int x, int y) {
        for (int i=0 ; i<8 ; i++) {
            int aroundX = x + xi[i];
            int aroundY = y + yi[i];
            if (!isValid(aroundX, aroundY)) continue;
            if (board[aroundY][aroundX] == '#') {
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<c && y<r;
    }
}
