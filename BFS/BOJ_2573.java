// BOJ - 2573
// Problem Sheet - https://www.acmicpc.net/problem/2573

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

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
        public void melt(int level) { this.h = Math.max(0, h - level); }
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
                if (map[i][j] <= 0) continue;
                ices.add(new Ice(j, i, map[i][j]));
            }
        }
        br.close();
    }

    private static int solve() {
        int time = 0;
        do {
            // 1. 녹는정도 정보 갱신
            for (Ice ice : ices) {
                int meltLevel = getMeltLevel(ice);
                ice.melt(meltLevel);
            }
            // 2. map 정보 업데이트
            for (Ice ice : ices) {
                int x = ice.getX();
                int y = ice.getY();
                map[y][x] = ice.getH();
            }
            // 3. List 갱신
            ices = ices.stream().filter(i -> i.getH() > 0).collect(Collectors.toList());
            time++;
        } while (!ices.isEmpty() && !isSeparated());
        return isSeparated() ? time : 0;
    }

    private static boolean isSeparated() {
        if (ices.isEmpty()) return false;
        int iceCount = bfs(ices.get(0));
        return iceCount != ices.size();
    }

    private static int bfs(Ice ice) {
        int count = 0;
        Queue<Ice> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(ice);
        visited[ice.getY()][ice.getX()] = true;
        count++;
        while (!queue.isEmpty()) {
            for (int i=0 ; i<4 ; i++) {
                int x = queue.peek().getX() + xi[i];
                int y = queue.peek().getY() + yi[i];
                if (!isValid(x, y) || map[y][x] <= 0 || visited[y][x]) continue;
                queue.add(new Ice(x, y, map[y][x]));
                visited[y][x] = true;
                count++;
            }
            queue.poll();
        }
        return count;
    }

    private static int getMeltLevel(Ice ice) {
        int level = 0;
        for (int i=0 ; i<4 ; i++) {
            int x = ice.getX() + xi[i];
            int y = ice.getY() + yi[i];
            if (!isValid(x, y) || map[y][x] > 0) continue;
            level++;
        }
        return level;
    }

    private static boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<M && y<N;
    }
}