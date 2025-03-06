// BOJ - 5427
// Problem Sheet - https://www.acmicpc.net/problem/5427

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

    private static int w, h;
    private static char[][] map;
    private static int[][] fireMap, escapeMap;
    private static Queue<Point> fireQueue, escapeQueue;
    private static int time;

    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final int[] xi = { -1, 1, 0, 0 };
    private static final int[] yi = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] row = br.readLine().split(" ");
            w = Integer.parseInt(row[0]);
            h = Integer.parseInt(row[1]);
            map = new char[h][w];
            fireMap = new int[h][w];
            escapeMap = new int[h][w];
            fireQueue = new ArrayDeque<>();
            escapeQueue = new ArrayDeque<>();
            for (int i=0 ; i<h ; i++) {
                row = br.readLine().split("");
                for (int j=0 ; j<w ; j++) {
                    map[i][j] = row[j].charAt(0);
                    if (map[i][j] == '@') {
                        escapeQueue.add(new Point(j, i));
                        escapeMap[i][j] = 1;
                    } else if (map[i][j] == '*') {
                        fireQueue.add(new Point(j, i));
                        fireMap[i][j] = 1;
                    }
                }
            }
            updateFireMap();
            sb.append(updateEscapeMap() ? time : IMPOSSIBLE).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void updateFireMap() {
        while (!fireQueue.isEmpty()) {
            Point cur = fireQueue.poll();
            for (int i=0 ; i<4 ; i++) {
                int nx = cur.getX() + xi[i];
                int ny = cur.getY() + yi[i];
                if (isOutOfRange(nx, ny) || map[ny][nx] == '#' || fireMap[ny][nx] > 0) continue;
                fireQueue.add(new Point(nx, ny));
                fireMap[ny][nx] = fireMap[cur.getY()][cur.getX()] + 1;
            }
        }
    }

    private static boolean updateEscapeMap() {
        boolean isEscapable = false;
        while (!escapeQueue.isEmpty()) {
            Point cur = escapeQueue.poll();
            if (isEscape(cur.getX(), cur.getY())) {
                isEscapable = true;
                time = escapeMap[cur.getY()][cur.getX()];
                break;
            }
            for (int i=0 ; i<4 ; i++) {
                int nx = cur.getX() + xi[i];
                int ny = cur.getY() + yi[i];
                if (isOutOfRange(nx, ny)
                        || map[ny][nx] == '#'
                        || escapeMap[ny][nx] > 0
                        || (fireMap[ny][nx] != 0 && fireMap[ny][nx] <= escapeMap[cur.getY()][cur.getX()] + 1)) continue;
                escapeQueue.add(new Point(nx, ny));
                escapeMap[ny][nx] = escapeMap[cur.getY()][cur.getX()] + 1;
            }
        }
        return isEscapable;
    }

    private static boolean isOutOfRange(int x, int y) {
        return !(x>=0 && y>=0 && x<w && y<h);
    }

    private static boolean isEscape(int x, int y) {
        return x == 0 || x == w-1 || y == 0 || y == h-1;
    }
}