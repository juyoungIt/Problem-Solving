// BOJ - 6593
// Problem Sheet - https://www.acmicpc.net/problem/6593

import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        private final int x;
        private final int y;
        private final int z;
        private final int time;

        public Point(int x, int y, int z, int time) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.time = time;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public int getZ() { return this.z; }
        public int getTime() { return this.time; }
    }

    private static int L, R, C;
    private static char[][][] building;
    private static boolean[][][] visited;
    private static Queue<Point> queue;

    private static final String SUCCESS = "Escaped in %d minute(s).";
    private static final String FAILED = "Trapped!";
    private static final int[] xi = { -1, 1, 0, 0, 0, 0 };
    private static final int[] yi = { 0, 0, -1, 1, 0, 0 };
    private static final int[] zi = { 0, 0, 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] input = br.readLine().split(" ");
            L = Integer.parseInt(input[0]);
            R = Integer.parseInt(input[1]);
            C = Integer.parseInt(input[2]);
            if (L == 0 && R == 0 && C == 0) break;
            building = new char[L][R][C];
            visited = new boolean[L][R][C];
            queue = new ArrayDeque<>();
            for (int i=0 ; i<L ; i++) {
                for (int j=0 ; j<R ; j++) {
                    String row = br.readLine();
                    for (int k=0 ; k<C ; k++) {
                        building[i][j][k] = row.charAt(k);
                        if (building[i][j][k] == 'S') {
                            queue.add(new Point(k, j, i, 0));
                            visited[i][j][k] = true;
                        }
                    }
                }
                br.readLine(); // remove empty line
            }
            int escapeTime = bfs();
            sb.append(escapeTime >= 0 ? String.format(SUCCESS, escapeTime) : FAILED).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int bfs() {
        int time = -1;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (building[cur.getZ()][cur.getY()][cur.getX()] == 'E') {
                time = cur.getTime();
                break;
            }
            for (int i=0 ; i<6 ; i++) {
                int nx = cur.getX() + xi[i];
                int ny = cur.getY() + yi[i];
                int nz = cur.getZ() + zi[i];
                if (isOutOfRange(nx, ny, nz) || visited[nz][ny][nx] || building[nz][ny][nx] == '#') continue;
                queue.add(new Point(nx, ny, nz, cur.getTime() + 1));
                visited[nz][ny][nx] = true;
            }
        }
        return time;
    }

    private static boolean isOutOfRange(int x, int y, int z) {
        return !(x>=0 && y>=0 && z>=0 && x<C && y<R && z<L);
    }
}