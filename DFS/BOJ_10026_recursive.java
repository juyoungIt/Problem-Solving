// BOJ - 10026
// Problem Sheet - https://www.acmicpc.net/problem/10026

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
    private static char[][] painting;
    private static boolean[][] visited;

    private static final int[] xi = { -1, 1, 0, 0 };
    private static final int[] yi = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        painting = new char[N][N];
        for (int i=0 ; i<N ; i++) {
            char[] row = br.readLine().toCharArray();
            System.arraycopy(row, 0, painting[i], 0, N);
        }
        visited = new boolean[N][N];
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i=0 ; i<N ; i++) {
            for (int j=0 ; j<N ; j++) {
                if (visited[i][j]) continue;
                dfs(j, i, painting[i][j], true);
                count++;
            }
        }
        sb.append(count).append(" ");
        count = 0;
        visited = new boolean[N][N];
        for (int i=0 ; i<N ; i++) {
            for (int j=0 ; j<N ; j++) {
                if (visited[i][j]) continue;
                dfs(j, i, painting[i][j], false);
                count++;
            }
        }
        sb.append(count);
        return sb.toString();
    }

    private static void dfs(int sx, int sy, char color, boolean isNormal) {
        visited[sy][sx] = true;
        for (int i=0 ; i<4 ; i++) {
            int nx = sx + xi[i];
            int ny = sy + yi[i];
            if (isNotValid(nx, ny) || visited[ny][nx]) continue;
            if (isNormal && painting[ny][nx] != color) continue;
            if (!isNormal && painting[ny][nx] != color
                    && !((painting[ny][nx] == 'R' && color == 'G')
                    || (painting[ny][nx] == 'G' && color == 'R'))) continue;
            dfs(nx, ny, painting[ny][nx], isNormal);
        }
    }

    private static boolean isNotValid(int x, int y) {
        return !(x>=0 && y>=0 && x<N && y<N);
    }
}