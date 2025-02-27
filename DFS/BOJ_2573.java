// BOJ - 2573
// Problem Sheet - https://www.acmicpc.net/problem/2573

import java.util.*;
import java.io.*;

public class Main {

    static class Ice {
        private final int x;
        private final int y;
        private int h;

        public Ice(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public int getH() { return this.h; }
        public void melt(int level) { this.h = Math.max(0, this.h - level); }
    }

    private static int N, M;
    private static int[][] map;
    private static List<Ice> ices = new ArrayList<>();

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
        map = new int[N][M];
        for (int i=0 ; i<N ; i++) {
            row = br.readLine().split(" ");
            for (int j=0 ; j<M ; j++) {
                map[i][j] = Integer.parseInt(row[j]);
                if (map[i][j] > 0) {
                    ices.add(new Ice(j, i, map[i][j]));
                }
            }
        }
        br.close();
    }

    private static int solve() {
        int year = 0;
        do {
            // 1. 빙산의 상태 업데이트
            for (Ice ice : ices) {
                ice.melt(getMeltLevel(ice.getX(), ice.getY()));
            }
            // 2. 1의 값을 기반으로 map 정보 업데이트 + 사라진 빙산 제거처리
            for (int i=0 ; i<ices.size() ; i++) {
                Ice ice = ices.get(i);
                map[ice.getY()][ice.getX()] = ice.getH();
                if (ice.getH() == 0) {
                    ices.set(i, ices.get(ices.size() - 1));
                    ices.remove(ices.size() - 1);
                    i--;
                }
            }
            year++;
        } while (!ices.isEmpty() && !isSeparated());
        return isSeparated() ? year : 0;
    }

    private static int getMeltLevel(int x, int y) {
        int count = 0;
        for (int i=0 ; i<4 ; i++) {
            int nx = x + xi[i];
            int ny = y + yi[i];
            if (map[ny][nx] != 0) continue;
            count++;
        }
        return count;
    }

    private static int dfs(Ice ice) {
        int iceCount = 0;
        Deque<Ice> stack = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        stack.push(ice);
        visited[ice.getY()][ice.getX()] = true;
        iceCount++;
        while (!stack.isEmpty()) {
            boolean allConnected = true;
            for (int i=0 ; i<4 ; i++) {
                int nx = stack.peek().getX() + xi[i];
                int ny = stack.peek().getY() + yi[i];
                if (map[ny][nx] == 0 || visited[ny][nx]) continue;
                stack.push(new Ice(nx, ny, map[ny][nx]));
                visited[ny][nx] = true;
                iceCount++;
                allConnected = false;
                break;
            }
            if (allConnected) stack.pop();
        }
        return iceCount;
    }

    private static boolean isSeparated() {
        if (ices.isEmpty()) return false;
        return ices.size() != dfs(ices.get(0));
    }
}