// BOJ - 7569
// Problem Sheet - https://www.acmicpc.net/problem/7569

import java.util.*;
import java.io.*;

class Location {
    private final int x;
    private final int y;
    private final int z;
    private final int depth;

    public Location(int x, int y, int z, int depth) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.depth = depth;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public int getZ() { return this.z; }
    public int getDepth() { return this.depth; }
}

public class Main {
    private static Queue<Location> queue; // bfs에 사용하는 queue
    private static int m; // 상자 가로 칸
    private static int n; // 상자 세로 칸
    private static int h; // 쌓이는 상자 수
    private static int[][][] map; // 토마토를 놓는 트레이
    private static boolean[][][] visit; // 방문정보
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        queue = new LinkedList<>();
        boolean done = true; // 이미 모든 토마토가 익었는 가?
        int days = -1;

        // 토마토를 담는 트레이에 대한 기본정보를 구성함
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][n][m];
        visit = new boolean[h][n][m];

        // 각 층별로 토마토의 정보를 입력
        for(int i=0 ; i<h ; i++) {
            for(int j=0 ; j<n ; j++) {
                st = new StringTokenizer(bf.readLine());
                for(int k=0 ; k<m ; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 1) {
                        visit[i][j][k] = true;
                        queue.add(new Location(k, j, i, 0));
                    }
                    if(map[i][j][k] == 0) done = false;
                }
            }
        }

        if(done) days = 0;
        else days = bfs();
        System.out.println(days);

        bf.close();
        System.exit(0);
    }

    static int bfs() {
        int[] xi = {-1, 1, 0, 0, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1, 0, 0}; // y-increment
        int[] zi = {0, 0, 0, 0, -1, 1}; // z-increment
        int days = 0;

        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            int curZ = queue.peek().getZ();
            int curDepth = queue.peek().getDepth();
            if(days < curDepth)
                days = curDepth;
            for(int i=0 ; i<6 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                int tz = curZ + zi[i];
                if(validation(tx, ty, tz) && map[tz][ty][tx] == 0 && !visit[tz][ty][tx]) {
                    visit[tz][ty][tx] = true;
                    map[tz][ty][tx] = 2;
                    queue.add(new Location(tx, ty, tz, curDepth+1));
                }
            }
            queue.poll();
        }
        return (isFinished()) ? days : -1;
    }

    // 모든 토마토가 익었는 지 검사함
    static boolean isFinished() {
        boolean result = true;
        for(int i=0 ; i<h ; i++) {
            for(int j=0 ; j<n ; j++) {
                for(int k=0 ; k<m ; k++) {
                    if(map[i][j][k] == 0) {
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }

    static boolean validation(int x, int y, int z) {
        return (x>=0 && y>=0 && z>=0 && x<m && y<n && z<h);
    }
}