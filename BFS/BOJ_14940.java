// BOJ - 14940
// Problem Sheet - https://www.acmicpc.net/problem/14940

import java.util.*;
import java.io.*;

class Location {
    private final int x;
    private final int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Queue<Location> queue = new LinkedList<>(); // bfs를 수행하기 위한 queue
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment

        int n = Integer.parseInt(st.nextToken()); // 세로의 크기
        int m = Integer.parseInt(st.nextToken()); // 가로의 크기
        int[][] map = new int[n][m]; // 지도
        boolean[][] visit = new boolean[n][m]; // 방문정보 저장
        int targetX = 0, targetY = 0;
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    targetX = j;
                    targetY = i;
                }
            }
        }

        visit[targetY][targetX] = true;
        map[targetY][targetX] = 0;
        queue.add(new Location(targetX, targetY));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, m, n) && map[ty][tx] == 1 && !visit[ty][tx]) {
                    visit[ty][tx] = true;
                    map[ty][tx] = map[curY][curX] + 1;
                    queue.add(new Location(tx, ty));
                }
            }
            queue.poll();
        }

        // 도달할 수 없는 위치를 찾음
        for(int i=0 ; i<n ; i++)
            for(int j=0 ; j<m ; j++)
                if(!visit[i][j] && map[i][j] != 0)
                    map[i][j] = -1;

        // 종합된 결과를 출력함
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }

        bf.close();
        System.exit(0);
    }

    public static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=0 && y>=0 && x<xLimit && y<yLimit);
    }
}