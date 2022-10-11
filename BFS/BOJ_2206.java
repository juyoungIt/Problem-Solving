// BOJ - 2206
// Problem Sheet - https://www.acmicpc.net/problem/2206

import java.util.*;
import java.io.*;

class Location {
    private final int x; // x좌표
    private final int y; // y좌표
    private final int depth; // 탐색의 깊이
    private final int breakWall; // 벽을 부순 적이 있는 가

    public Location(int x, int y, int depth, int breakWall) {
        this.x = x;
        this.y = y;
        this.depth = depth;
        this.breakWall = breakWall;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public int getDepth() { return this.depth; }
    public int getBreakWall() { return this.breakWall; }
}

public class Main {
    private static int n; // 지도 세로
    private static int m; // 지도 가로
    private static int[][] map; // 지도정보
    private static boolean[][][] visit; // 방문정보 (0: 벽을 부순 적 없음, 1: 벽을 부순적 있음)
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken()); // 지도 세로
        m = Integer.parseInt(st.nextToken()); // 지도 가로
        map = new int[n][m]; // 지도 정보
        visit = new boolean[2][n][m]; // 방문정보 (0: 벽을 부순 적 없음, 1: 벽을 부순적 있음)

        // 입력 내용을 바탕으로 지도의 정보를 구성함
        for(int i=0 ; i<n ; i++) {
            String tmp = bf.readLine();
            for(int j=0 ; j<m ; j++)
                map[i][j] = Integer.parseInt(tmp.charAt(j)+"");
        }

        // BFS를 수행하며 최적을 솔루션을 구함
        System.out.println(bfs());

        bf.close();
        System.exit(0);
    }

    static int bfs() {
        Queue<Location> queue = new LinkedList<>();
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment
        int count = -1; // 목표 지점에 도착하기 위해 필요한 이동 수

        // 시작지점 위치를 주입함
        visit[0][0][0] = true;
        queue.add(new Location(0, 0, 1, 0));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            int curDepth = queue.peek().getDepth();
            int curBreakWall = queue.peek().getBreakWall();

            // 목표 지점에 도착한 경우
            if(curX == m-1 && curY == n-1) {
                count = curDepth;
                break;
            }

            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                // 사용할 수 있는 유효한 좌표인가?
                if(validation(tx, ty)) {
                    // 방문 가능한 빈 공간을 만난 경우
                    if(map[ty][tx] == 0 && !visit[curBreakWall][ty][tx]) {
                        visit[curBreakWall][ty][tx] = true;
                        queue.add(new Location(tx, ty, curDepth+1, curBreakWall));
                    }
                    // 방문이 불가능한 벽을 만난 경우
                    else if(curBreakWall == 0 && map[ty][tx] == 1 && !visit[curBreakWall][ty][tx]) {
                        visit[curBreakWall][ty][tx] = true;
                        queue.add(new Location(tx, ty, curDepth+1, 1));
                    }
                }
            }
            queue.poll();
        }
        return count;
    }

    static boolean validation(int x, int y) { return (x>=0 && y>=0 && x<m && y<n); }
}