// BOJ - 2468
// Problem Sheet - https://www.acmicpc.net/problem/2468

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
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine()); // 지도의 크기 n
        int[][] map = new int[n][n]; // 각 지역의 높이 정보가 기록된 지도
        int[][] clonedMap = new int[n][n]; // 각 case에 대한 탐색을 위해 복사가 이뤄지는 map
        int maxHeight = 0; // 지도에서 가장 고지대의 높이
        int answer = 0; // 안전지대 수의 최댓값

        // 입력된 정보를 기반으로 지도를 구성함
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<n ; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                if(maxHeight < tmp)
                    maxHeight = tmp;
            }
        }

        // 강수량에 대한 탐색을 진행함
        for(int h=0 ; h<=maxHeight ; h++) {
            int tmp = 0; // 높이가 h일 때의 안전구역의 수
            // 해당 높이에 대한 지도를 구성함
            for(int i=0 ; i<n ; i++)
                for(int j=0 ; j<n ; j++)
                    clonedMap[i][j] = (map[i][j] <= h) ? -1 : map[i][j];
            // 구성된 지도를 바탕으로 bfs를 수행함
            for(int i=0 ; i<n ; i++) {
                for(int j=0 ; j<n ; j++) {
                    if(clonedMap[i][j] > 0) {
                        bfs(clonedMap, j, i);
                        tmp++;
                    }
                }
            }
            if(answer < tmp)
                answer = tmp;
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    public static void bfs(int[][] map, int startX, int startY) {
        Queue<Location> queue = new LinkedList<>();
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment

        map[startY][startX] = 0;
        queue.add(new Location(startX, startY));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, map.length) && map[ty][tx] > 0) {
                    map[ty][tx] = 0;
                    queue.add(new Location(tx, ty));
                }
            }
            queue.poll();
        }
    }

    public static boolean validation(int x, int y, int n) {
        return (x>=0 && y>=0 && x<n && y<n);
    }
}