// BOJ - 17086
// Problem Sheet - https://www.acmicpc.net/problem/17086

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
        Queue<Location> queue = new LinkedList<>(); // BFS를 수행하기 위한 queue
        int[] xi = {-1, 0, 1, 1, 1, 0, -1, -1}; // x-increment
        int[] yi = {-1, -1, -1, 0, 1, 1, 1, 0}; // y-increment

        int n = Integer.parseInt(st.nextToken()); // 공간의 크기 (세로)
        int m = Integer.parseInt(st.nextToken()); // 공간의 크기 (가로)
        int[][] map = new int[n][m]; // 상어가 표시하는 거리
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 이 아기상어를 의미하게 됨
                if(map[i][j] == 1)
                    queue.add(new Location(j, i)); // 가장 가까운 상어를 찾기 위한 사전작업
            }
        }

        // 아기 상어가 있는 지점에 대하여 bfs 수행
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<8 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, map[0].length, map.length) && map[ty][tx] == 0) {
                    map[ty][tx] = map[curY][curX] + 1;
                    queue.add(new Location(tx, ty));
                }
            }
            queue.poll();
        }

        // 가장 큰 안전거리의 값을 찾음
        int answer = -1;
        for(int i=0 ; i<n ; i++)
            for(int j=0 ; j<m ; j++)
                if(map[i][j] > answer)
                    answer = map[i][j];

        System.out.println(answer-1);

        bf.close();
        System.exit(0);
    }

    public static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=0 && y>=0 && x<xLimit && y<yLimit);
    }
}