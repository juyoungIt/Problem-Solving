// BOJ - 1194
// Problem Sheet - https://www.acmicpc.net/problem/1194

import java.util.*;
import java.io.*;

public class Main {

    enum Type {
        EMPTY, WALL, KEY, DOOR, EXIT
    }

    static class Status {
        private final int x;
        private final int y;
        private final int keys;
        private final int dist;

        public Status(int x, int y, int keys, int dist) {
            this.x = x;
            this.y = y;
            this.keys = keys;
            this.dist = dist;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public int getKeys() { return this.keys; }
        public int getDist() { return this.dist; }
    }

    private static int N, M;
    private static char[][] map;
    private static boolean[][][] visited;

    private static final Queue<Status> queue = new ArrayDeque<>();
    private static final int[] xi = { -1, 1, 0, 0 };
    private static final int[] yi = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new char[N][M];
        visited = new boolean[N][M][64];
        for (int i=0 ; i<N ; i++) {
            String row = br.readLine();
            for (int j=0 ; j<M ; j++) {
                map[i][j] = row.charAt(j);
                if (map[i][j] == '0') {
                    queue.add(new Status(j, i, 0, 0));
                    visited[i][j][0] = true;
                }
            }
        }
        br.close();
    }

    private static int solve() {
        int minDist = -1;
        while (!queue.isEmpty()) {
            Status cur = queue.poll();
            if (map[cur.getY()][cur.getX()] == '1') {
                minDist = cur.getDist();
                break;
            }
            for (int i=0 ; i<4 ; i++) {
                int nx = cur.getX() + xi[i];
                int ny = cur.getY() + yi[i];
                if (isOutOfRange(nx, ny)) continue;
                switch (getType(map[ny][nx])) {
                    case EMPTY:
                    case EXIT:
                        if (!visited[ny][nx][cur.getKeys()]) {
                            queue.add(new Status(nx, ny, cur.getKeys(), cur.getDist() + 1));
                            visited[ny][nx][cur.getKeys()] = true;
                        }
                        break;
                    case WALL:
                        continue;
                    case KEY:
                        int nKeys = cur.getKeys() | (1 << (map[ny][nx] - 'a'));
                        if (!visited[ny][nx][nKeys]) {
                            queue.add(new Status(nx, ny, nKeys, cur.getDist() + 1));
                            visited[ny][nx][nKeys] = true;
                        }
                        break;
                    case DOOR:
                        if (!visited[ny][nx][cur.getKeys()] && (cur.getKeys() & (1 << (map[ny][nx] - 'A'))) != 0) {
                            queue.add(new Status(nx, ny, cur.getKeys(), cur.getDist() + 1));
                            visited[ny][nx][cur.getKeys()] = true;
                        }
                        break;
                }
            }
        }
        return minDist;
    }

    private static boolean isOutOfRange(int x, int y) {
        return !(x>=0 && y>=0 && x<M && y<N);
    }

    private static Type getType(char c) {
        if (c == '.') return Type.EMPTY;
        else if (c == '#') return Type.WALL;
        else if (c - 'a' >= 0 && c - 'a' <= 5) return Type.KEY;
        else if (c - 'A' >= 0 && c - 'A' <= 5) return Type.DOOR;
        else return Type.EXIT;
    }
}