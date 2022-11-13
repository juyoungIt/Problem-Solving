// BOJ - 24819
// Problem Sheet - https://www.acmicpc.net/problem/24819

import java.util.*;
import java.io.*;

public class Main {

    static class Location {
        private final int x;
        private final int y;
        private final int depth;

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

        int t = Integer.parseInt(st.nextToken()); // 제한 시간
        int n = Integer.parseInt(st.nextToken()); // 구역의 세로길이
        int m = Integer.parseInt(st.nextToken()); // 구역의 가로길이
        char[][] map = new char[n][m]; // 구역의 각 상태정보
        int startX = 0, startY = 0; // 시작위치의 좌표

        for(int i=0 ; i<n ; i++) {
            String tmp = bf.readLine();
            for(int j=0 ; j<m ; j++) {
                map[i][j] = tmp.charAt(j);
                if(map[i][j] == 'S') {
                    startX = j;
                    startY = i;
                }
            }
        }

        int result = findEscapeRoute(map, startX, startY, t);
        System.out.println((result != -1) ? result : "NOT POSSIBLE");

        bf.close();
        System.exit(0);
    }

    static int findEscapeRoute(char[][] map, int startX, int startY, int timeLimit) {
        Queue<Location> queue = new LinkedList<>(); // bfs에 사용하는 queue
        boolean[][] visit = new boolean[map.length][map[0].length]; // 방문정보
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment
        boolean escapeFinished = false; // 탈출했는 가?
        int result = -1; // 탐색결과를 저장

        visit[startY][startX] = true;
        queue.add(new Location(startX, startY, 0));
        while(!queue.isEmpty()) {
            if(escapeFinished) break;

            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            int curDepth = queue.peek().getDepth();

            // 시간 제한을 초과한 경우
            if(curDepth > timeLimit) break;

            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                // 국경을 탈출했는 지에 대한 여부 확인
                if(isReached(tx, ty, map[0].length, map.length)) {
                    result = curDepth;
                    escapeFinished = true;
                    break;
                }
                if(validation(tx, ty, map[0].length, map.length) && map[ty][tx] != '1' && !visit[ty][tx]) {
                    if(map[ty][tx] == '0'
                            || (map[ty][tx] == 'U' && curY+1 == ty)
                            || (map[ty][tx] == 'D' && curY-1 == ty)
                            || (map[ty][tx] == 'L' && curX+1 == tx)
                            || (map[ty][tx] == 'R' && curX-1 == tx)) {
                        visit[ty][tx] = true;
                        queue.add(new Location(tx, ty, curDepth+1));
                    }
                }
            }
            queue.poll();
        }
        return result;
    }

    static boolean isReached(int x, int y, int xLimit, int yLimit) {
        return (x<0 || y<0 || x>=xLimit || y>=yLimit);
    }

    static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=0 && y>=0 && x<xLimit && y<yLimit);
    }
}