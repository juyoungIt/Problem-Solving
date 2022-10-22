// BOJ - 6080
// Problem Sheet - https://www.acmicpc.net/problem/6080

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

        int r = Integer.parseInt(st.nextToken()); // 지도의 세로
        int c = Integer.parseInt(st.nextToken()); // 지도의 가로
        int[][] map = new int[r][c]; // 지도의 상태 저장
        int answer = 0;

        for(int i=0 ; i<r ; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<c ; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0 ; i<r ; i++) {
            for(int j=0 ; j<c ; j++) {
                if(map[i][j] > 0) {
                    bfs(map, j, i);
                    answer++;
                }
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    static void bfs(int[][] map, int startX, int startY) {
        Queue<Location> queue = new LinkedList<>();
        int[] xi = {-1, 1, 0, 0, 1, 1, -1, -1}; // x-increment
        int[] yi = {0, 0, -1, 1, 1, -1, 1, -1}; // y-increment

        map[startY][startX] = -1;
        queue.add(new Location(startX, startY));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<8 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, map[0].length, map.length) && map[ty][tx] > 0) {
                    map[ty][tx] = -1;
                    queue.add(new Location(tx, ty));
                }
            }
            queue.poll();
        }
    }

    static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=0 && y>=0 && x<xLimit && y<yLimit);
    }
}