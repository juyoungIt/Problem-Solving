// BOJ - 1743
// Problem Sheet - https://www.acmicpc.net/problem/1743

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
        int n = Integer.parseInt(st.nextToken()); // 통로 세로의 길이
        int m = Integer.parseInt(st.nextToken()); // 통로 가로의 길이
        int k = Integer.parseInt(st.nextToken()); // 음식물 쓰레기의 수
        int answer = 0; // 음식물 쓰레기의 최대 크기

        // 입력된 정보를 바탕으로 map을 구성함
        int[][] map = new int[n+1][m+1]; // 통로를 표현하는 map
        for(int i=0 ; i<k ; i++) {
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }

        // bfs를 수행하며 음식물 쓰레기의 최대 넓이를 찾음
        for(int i=1 ; i<=n ; i++) {
            for(int j=1 ; j<=m ; j++) {
                if(map[i][j] == 1) {
                    int area = bfs(map, j, i);
                    if(area > answer)
                        answer = area;
                }
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    public static int bfs(int[][] map, int startX, int startY) {
        Queue<Location> queue = new LinkedList<>(); // bfs를 수행하기 위한 queue
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment
        int area = 0; // 음식물의 넓이

        map[startY][startX] = 2;
        queue.add(new Location(startX, startY));
        area++;
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, map[0].length, map.length) && map[ty][tx] == 1) {
                    map[ty][tx] = 2;
                    queue.add(new Location(tx, ty));
                    area++;
                }
            }
            queue.poll();
        }
        return area;
    }

    public static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>0 && y>0 && x<xLimit && y<yLimit);
    }
}