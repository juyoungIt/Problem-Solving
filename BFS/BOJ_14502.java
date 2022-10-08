// BOJ - 14502
// Problem Sheet - https://www.acmicpc.net/problem/14502

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
    private static int n; // 지도 세로
    private static int m; // 지도 가로
    private static int[][] map; // 지도
    private static Queue<Location> viruses; // 바이러스의 초기위치 저장
    private static int maxSafeArea = 0; // 안전구역 넓이의 최댓값
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken()); // 지도 세로
        m = Integer.parseInt(st.nextToken()); // 지도 가로
        map = new int[n][m]; // 지도
        viruses = new LinkedList<>(); // 바이러스의 위치를 저장
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2)
                    viruses.add(new Location(j, i));
            }
        }

        buildWall(0);
        System.out.println(maxSafeArea);

        bf.close();
        System.exit(0);
    }

    static void buildWall(int cnt) {
        if(cnt == 3) {
            int result = bfs();
            if(maxSafeArea < result)
                maxSafeArea = result;
            return;
        }
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(cnt+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static int bfs() {
        int[][] curMap = new int[n][m]; // 현재 지도상태 정보를 저장
        Queue<Location> queue = new LinkedList<>(viruses); // bfs에 사용하는 queue
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment
        int safeArea = 0; // 안전구역의 넓이

        // 현재 지도의 상태정보를 복사
        for(int i=0 ; i<n ; i++)
            System.arraycopy(map[i], 0, curMap[i], 0, m);

        // 현재의 위치에 대해서 bfs를 수행함
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty) && curMap[ty][tx] == 0) {
                    curMap[ty][tx] = 2; // 바이러스가 퍼져나감
                    queue.add(new Location(tx, ty));
                }
            }
            queue.poll();
        }
        // 안전구역의 넓이를 구함
        for(int i=0 ; i<n ; i++)
            for(int j=0 ; j<m ; j++)
                if(curMap[i][j] == 0)
                    safeArea++;

        return safeArea;
    }

    static boolean validation(int x, int y) {
        return (x>=0 && y>=0 && x<m && y<n);
    }
}