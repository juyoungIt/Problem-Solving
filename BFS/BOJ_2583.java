// BOJ - 2538
// Problem Sheet - https://www.acmicpc.net/problem/2538

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
        int m = Integer.parseInt(st.nextToken()); // 직사각형의 세로길이
        int n = Integer.parseInt(st.nextToken()); // 직사각형의 가로길이
        int k = Integer.parseInt(st.nextToken()); // 입력되는 직사각형의 수
        int[][] map = new int[m][n]; // 사각형을 표현할 지도
        int totalCount = 0; // 식별된 구역의 수
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(); // 각 구역의 넓이를 오름차순 저장

        // 입력된 직사각형 정보를 바탕으로 지도 정보를 구성함
        for(int i=0 ; i<k ; i++) {
            st = new StringTokenizer(bf.readLine());
            int lbX = Integer.parseInt(st.nextToken()); // left bottom X
            int lbY = Integer.parseInt(st.nextToken()); // left bottom Y
            int rtX = Integer.parseInt(st.nextToken()); // right top X
            int rtY = Integer.parseInt(st.nextToken()); // right top Y
            for(int j=lbY ; j<rtY ; j++)
                for(int l=lbX ; l<rtX ; l++)
                    map[m-1-j][l] = 2;
        }

        // 구역의 수와 그 넓이를 구해야 함
        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(map[i][j] == 0) {
                    pQueue.add(bfs(map, j, i));
                    totalCount++;
                }
            }
        }

        System.out.println(totalCount);
        while(!pQueue.isEmpty())
            System.out.print(pQueue.poll() + " ");

        bf.close();
        System.exit(0);
    }

    public static int bfs(int[][] map, int startX, int startY) {
        Queue<Location> queue = new LinkedList<>(); // bfs를 위해 사용하는 queue
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment
        int area = 0; // 해당 bfs를 통해 탐색한 구역의 넓이

        map[startY][startX] = 1;
        queue.add(new Location(startX, startY));
        area++;
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, map[0].length, map.length) && map[ty][tx] == 0) {
                    map[ty][tx] = 1;
                    queue.add(new Location(tx, ty));
                    area++;
                }
            }
            queue.poll();
        }
        return area;
    }

    public static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=0 && y>=0 && x<xLimit && y<yLimit);
    }
}