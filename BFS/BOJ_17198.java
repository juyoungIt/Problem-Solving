// BOJ - 17198
// Problem Sheet - https://www.acmicpc.net/problem/17198

import java.util.*;
import java.io.*;

class Location {
    private final int x;     // x좌표
    private final int y;     // y좌표
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
        char[][] farm = new char[10][10]; // 농장의 상태
        int[] start = new int[2]; // 탐색 시작지점 (호수의 위치)

        // 입력 정보를 바탕으로 Farm을 구성함
        for(int i=0 ; i<10 ; i++) {
            String row = bf.readLine(); // i번째 라인의 정보
            for(int j=0 ; j<10 ; j++) {
                farm[i][j] = row.charAt(j);
                if(farm[i][j] == 'L') {
                    start[0] = j;
                    start[1] = i;
                }
            }
        }

        // bfs를 수행하며 진화에 필요한 가장 적은 수의 소를 구함
        System.out.println(bfs(farm, start));

        bf.close();
        System.exit(0);
    }

    public static int bfs(char[][] farm, int[] start) {
        Queue<Location> queue = new LinkedList<>(); // bfs 수행에 필요한 queue
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment
        int minDepth = 0; // 진화에 필요한 depth의 최솟값
        boolean isReached = false; // 목표지점 도달여부

        farm[start[1]][start[0]] = 'C';
        queue.add(new Location(start[0], start[1], 0));
        while(!queue.isEmpty()) {
            if(isReached) break;
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            int curDepth = queue.peek().getDepth();
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                int tDepth = curDepth + 1;
                if(validation(tx, ty) && (farm[ty][tx] == '.' || farm[ty][tx] == 'B')) {
                    if(farm[ty][tx] == 'B') {
                        isReached = true;
                        minDepth = curDepth;
                        break;
                    }
                    farm[ty][tx] = 'C';
                    queue.add(new Location(tx, ty, tDepth));
                }
            }
            queue.poll();
        }
        return minDepth;
    }

    public static boolean validation(int x, int y) {
        return (x>=0 && y>=0 && x<10 && y<10);
    }
}