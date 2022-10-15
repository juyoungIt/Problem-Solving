// BOJ - 6004
// Problem Sheet - https://www.acmicpc.net/problem/6004

import java.util.*;
import java.io.*;

class Location {
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

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int x = Integer.parseInt(st.nextToken()); // 지도의 가로길이
        int y = Integer.parseInt(st.nextToken()); // 지도의 세로길이
        char[][] map = new char[y][x]; // 지도의 상태정보
        boolean[][] visit = new boolean[y][x]; // 각 위치에 대한 방문정보
        int startX = 0, startY = 0; // 출발지 좌표
        int targetX = 0, targetY = 0; // 목적지 좌표

        for(int i=0 ; i<y ; i++) {
            String str = bf.readLine();
            for(int j=0 ; j<x ; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'K') {
                    startX = j;
                    startY = i;
                }
                else if(map[i][j] == 'H') {
                    targetX = j;
                    targetY = i;
                }
            }
        }

        System.out.println(bfs(map, visit, startX, startY, targetX, targetY));

        bf.close();
        System.exit(0);
    }

    static int bfs(char[][] map, boolean[][] visit, int startX, int startY, int targetX, int targetY) {
        Queue<Location> queue = new LinkedList<>();
        int[] xi = {-1, -2, -2, -1, 1, 2, 2, 1}; // x-increment
        int[] yi = {2, 1, -1, -2, -2, -1, 1, 2}; // y-increment
        int result = 0; // 목표 지점 도착에 필요한 최소 이동횟수

        visit[startY][startX] = true;
        queue.add(new Location(startX, startY, 0));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            int curDepth = queue.peek().getDepth();
            if(curX == targetX && curY == targetY) {
                result = curDepth;
                break;
            }
            for(int i=0 ; i<8 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, map[0].length, map.length) && map[ty][tx] != '*' && !visit[ty][tx]) {
                    visit[ty][tx] = true;
                    queue.add(new Location(tx, ty, curDepth+1));
                }
            }
            queue.poll();
        }
        return result;
    }

    static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=0 && y>=0 && x<xLimit && y<yLimit);
    }
}