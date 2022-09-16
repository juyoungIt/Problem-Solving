// BOJ - 16174
// Problem Sheet - https://www.acmicpc.net/problem/16174

import java.util.*;
import java.io.*;

class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
}

public class Main {
    private static boolean isReached = false; // 목표위치에 대한 도달여부 저장
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine()); // 게임 구역의 크기
        int[][] map = new int[n][n]; // 게임구역에 대한 정보저장
        boolean[][] visit = new boolean[n][n]; // 해당 위치에 대한 방문여부 저장
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<n ; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(map, visit, 0, 0);
        System.out.println((isReached) ? "HaruHaru" : "Hing");

        bf.close();
        System.exit(0);
    }

    public static void dfs(int[][] map, boolean[][] visit, int startX, int startY) {
        int[] xi = {1, 0}; // x-increment
        int[] yi = {0, 1}; // y-increment

        if(map[startY][startX] == -1) {
            isReached = true;
            return;
        }
        if(!isReached) {
            visit[startY][startX] = true;
            for(int i=0 ; i<2 ; i++) {
                int tx = startX + xi[i] * map[startY][startX];
                int ty = startY + yi[i] * map[startY][startX];
                if(validation(tx, ty, map.length) && !visit[ty][tx]) {
                    visit[ty][tx] = true;
                    dfs(map, visit, tx, ty);
                }
            }
        }
    }

    public static boolean validation(int x, int y, int n) {
        return (x>=0 && y>=0 && x<n && y<n);
    }
}