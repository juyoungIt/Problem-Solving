// BOJ - 6229
// Problem Sheet - https://www.acmicpc.net/problem/6229

import java.util.*;
import java.io.*;

public class Main {

    static class Location {
        private final int x; // x좌표
        private final int y; // y좌표
        private final int depth; // 탐색의 깊이

        public Location(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public int getDepth() { return this.depth; }
    }

    private static int m; // 연못의 세로너비
    private static int n; // 연못의 가로너비
    private static int m1; // increment1
    private static int m2; // increment2
    private static int[] start = new int[2]; // 시작 위치의 좌표
    private static int[] target = new int[2]; // 도착 위치의 좌표

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        m = Integer.parseInt(st.nextToken()); // 연못 세로너비
        n = Integer.parseInt(st.nextToken()); // 연못 가로너비
        m1 = Integer.parseInt(st.nextToken()); // increment1
        m2 = Integer.parseInt(st.nextToken()); // increment2

        // 입력 값을 바탕으로 연못의 상태정보를 구성함
        int[][] pond = new int[m][n]; // 연못 상태저장
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<n ; j++) {
                pond[i][j] = Integer.parseInt(st.nextToken());
                if(pond[i][j] == 3) {
                    start[0] = j;
                    start[1] = i;
                } else if(pond[i][j] == 4) {
                    target[0] = j;
                    target[1] = i;
                }
            }
        }

        System.out.println(bfs(pond));

        bf.close();
        System.exit(0);
    }

    static int bfs(int[][] pond) {
        Queue<Location> queue = new LinkedList<>(); // bfs를 수행할 queue
        int[] xi = {m1, m1, -m1, -m1, m2, m2, -m2, -m2}; // x-increment
        int[] yi = {m2, -m2, m2, -m2, m1, -m1, m1, -m1}; // y-increment
        int result = 0;

        pond[start[1]][start[0]] = -1;
        queue.add(new Location(start[0], start[1], 0));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            int curDepth = queue.peek().getDepth();
            if(curX == target[0] && curY == target[1]) {
                result = curDepth;
                break;
            }
            for(int i=0 ; i<8 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty) && (pond[ty][tx] == 1 || pond[ty][tx] == 4)) {
                    if(pond[ty][tx] == 1)
                        pond[ty][tx] = -1;
                    queue.add(new Location(tx, ty, curDepth+1));
                }
            }
            queue.poll();
        }
        return result;
    }

    static boolean validation(int x, int y) {
        return (x>=0 && y>=0 && x<n && y<m);
    }
}