// BOJ - 17391
// Problem Sheet - https://www.acmicpc.net/problem/17391

import java.util.*;
import java.io.*;

class Location {
    private final int x;
    private final int y;
    private final int depth;
    private final int booster;

    public Location(int x, int y, int depth, int booster) {
        this.x = x;
        this.y = y;
        this.depth = depth;
        this.booster = booster;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public int getDepth() { return this.depth; }
    public int getBooster() { return this.booster; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken()); // 맵의 세로의 길이
        int m = Integer.parseInt(st.nextToken()); // 맵의 가로의 길이
        int[][] map = new int[n][m]; // 지도정보를 나타내는 map (0: 이미 방문한 지점)
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<m ; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs(map, 0, 0));

        bf.close();
        System.exit(0);
    }

    static int bfs(int[][] map, int startX, int startY) {
        Queue<Location> queue = new LinkedList<>();
        int result = 0;

        queue.add(new Location(startX, startY, 0, map[startY][startX]));
        map[startY][startX] = 0; // 방문여부를 표시
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            int curDepth = queue.peek().getDepth();
            int curBooster = queue.peek().getBooster();
            if(curX == map[0].length-1 && curY == map.length-1) {
                result = curDepth;
                break;
            }
            for(int i=1 ; i<=curBooster ; i++) {
                int tx = curX + i;
                int ty = curY + i;
                if(validation(tx, curY, map[0].length, map.length) && map[curY][tx] > 0) {
                    queue.add(new Location(tx, curY, curDepth+1, map[curY][tx]));
                    map[curY][tx] = 0;
                }
                if(validation(curX, ty, map[0].length, map.length) && map[ty][curX] > 0) {
                    queue.add(new Location(curX, ty, curDepth+1, map[ty][curX]));
                    map[ty][curX] = 0;
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