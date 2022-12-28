// BOJ - 5993
// Problem Sheet - https://www.acmicpc.net/problem/5993

import java.util.*;
import java.io.*;

public class Main {
    static class Location {
        private final int x; // x좌표
        private final int y; // y좌표
        private final int depth; // 탐색의 depth

        public Location(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public int getDepth() { return this.depth; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int x = Integer.parseInt(st.nextToken()); // 목초지의 너비
        int y = Integer.parseInt(st.nextToken()); // 목초지의 높이
        int mx = Integer.parseInt(st.nextToken()); // milkweed의 x좌표
        int my = Integer.parseInt(st.nextToken()); // milkweed의 y좌표

        // 목초지의 초기상태 정보를 업데이트
        char[][] map = new char[y+1][x+1]; // 목초지의 상태
        for(int i=1 ; i<=y ; i++) {
            String row = bf.readLine();
            for(int j=1 ; j<=x ; j++) {
                map[i][j] = row.charAt(j-1);
            }
        }

        System.out.println(bfs(map, mx, my));

        bf.close();
        System.exit(0);
    }

    private static int bfs(char[][] map, int startX, int startY) {
        Queue<Location> queue = new LinkedList<>(); // bfs에 사용할 queue
        int[] xi = {-1, 1, 0, 0, -1, -1, 1, 1}; // x-increment
        int[] yi = {0, 0, -1, 1, -1, 1, -1, 1}; // y-increment
        int result = 0;

        if(map[map.length-startY][startX] == '.') {
            map[map.length-startY][startX] = 'M';
        }
        queue.add(new Location(startX, startY, 0));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            int curDepth = queue.peek().getDepth();
            result = curDepth;
            for(int i=0 ; i<8 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, map[0].length, map.length) && map[map.length-ty][tx] == '.') {
                    map[map.length-ty][tx] = 'M';
                    queue.add(new Location(tx, ty, curDepth+1));
                }
            }
            queue.poll();
        }
        return result;
    }

    static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=1 && y>=1 && x<xLimit && y<yLimit);
    }
}