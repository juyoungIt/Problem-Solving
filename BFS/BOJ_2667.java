// BOJ - 2667
// Problem Sheet - https://www.acmicpc.net/problem/2667

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
        int n = Integer.parseInt(bf.readLine()); // 지도의 크기
        int[][] map = new int[n][n]; // 지도
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(); // 단지 수 저장

        // 입력 내용으로부터 지도를 구성함
        for(int i=0 ; i<n ; i++) {
            String tmp = bf.readLine();
            for(int j=0 ; j<n ; j++)
                map[i][j] = Integer.parseInt(tmp.charAt(j) + "");
        }

        // 지도를 분석함
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(map[i][j] == 1)
                    pQueue.add(bfs(map, j, i));
            }
        }

        // 수집된 정보를 출력
        System.out.println(pQueue.size());
        while(!pQueue.isEmpty())
            System.out.println(pQueue.poll());

        bf.close();
        System.exit(0);
    }

    public static int bfs(int[][] map, int startX, int startY) {
        Queue<Location> queue = new LinkedList<>(); // bfs를 위해 사용할 queue
        int[] xi = {-1, 1, 0, 0};
        int[] yi = {0, 0, -1, 1};
        int townSize = 0; // 단지 수

        map[startY][startX] = 2;
        queue.add(new Location(startX, startY));
        townSize++;
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, map.length) && map[ty][tx] == 1) {
                    map[ty][tx] = 2;
                    queue.add(new Location(tx, ty));
                    townSize++;
                }
            }
            queue.poll();
        }
        return townSize;
    }

    public static boolean validation(int x, int y, int n) {
        if(x<0 || y<0 || x>n-1 || y>n-1)
            return false;
        return true;
    }
}