// BOJ - 17129
// Problem Sheet - https://www.acmicpc.net/problem/17129

import java.util.*;
import java.io.*;

class Location {
    private final int x; // x좌표
    private final int y; // y좌표
    private final int depth; // 탐색의 depth

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

        int n = Integer.parseInt(st.nextToken()); // 정보섬 세로의 길이
        int m = Integer.parseInt(st.nextToken()); // 정보섬 가로의 길이
        int[][] map = new int[n][m]; // 정보섬의 상태
        int startX = 0, startY = 0; // 딱따구리의 위치좌표 (시작점)

        String inputStr;
        for(int i=0 ; i<n ; i++) {
            inputStr = bf.readLine();
            for(int j=0 ; j<m ; j++) {
                map[i][j] = Integer.parseInt(inputStr.charAt(j)+"");
                if(map[i][j] == 2) {
                    startX = j;
                    startY = i;
                }
            }
        }

        // bfs를 수행해야 최소해를 구함
        int answer = bfs(map, startX, startY);
        if(answer == -1)
            System.out.println("NIE");
        else {
            System.out.println("TAK");
            System.out.println(answer);
        }

        bf.close();
        System.exit(0);
    }

    static int bfs(int[][] map, int startX, int startY) {
        Queue<Location> queue = new LinkedList<>(); // bfs를 위해 사용하는 queue
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment
        int minDepth = -1;

        map[startY][startX] = 1;
        queue.add(new Location(startX, startY, 0));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            int curDepth = queue.peek().getDepth();
            if(map[curY][curX] >= 2) {
                minDepth = curDepth;
                break;
            }
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                int tDepth = curDepth + 1;
                if(validation(tx, ty, map[0].length, map.length) && map[ty][tx] != 1) {
                    if(map[ty][tx] == 0) map[ty][tx] = 1;
                    queue.add(new Location(tx, ty, tDepth));
                }
            }
            queue.poll();
        }
        return minDepth;
    }

    static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=0 && y>=0 && x<xLimit && y<yLimit);
    }
}