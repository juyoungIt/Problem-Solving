// BOJ - 15242
// Problem Sheet - https://www.acmicpc.net/problem/15242

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

        String startStr = bf.readLine();
        String targetStr = bf.readLine();
        int startX = getIndexFromAlpha(startStr.charAt(0));
        int startY = Integer.parseInt(startStr.charAt(1)+"");
        int targetX = getIndexFromAlpha(targetStr.charAt(0));
        int targetY = Integer.parseInt(targetStr.charAt(1)+"");

        System.out.println(findDest(startX, startY, targetX, targetY));
        bf.close();
        System.exit(0);
    }

    static int getIndexFromAlpha(char c) { return (int)c - 96; }

    static boolean validation(int x, int y) { return (x>0 && y>0 && x<=8 && y<=8); }

    static int findDest(int startX, int startY, int targetX, int targetY) {
        Queue<Location> queue = new LinkedList<>(); // bfs에 사용할 queue
        boolean[][] visit = new boolean[9][9]; // 방문정보
        int[] xi = {-1, -2, -2, -1, 1, 2, 2, 1}; // x-increment
        int[] yi = {-2, -1, 1, 2, 2, 1, -1, -2}; // y-increment
        int result = 0;

        visit[startY][startX] = true;
        queue.add(new Location(startX, startY, 0));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            int curDepth = queue.peek().getDepth();
            if(curX == targetX && curY == targetY) {
                result = curDepth;
                break;
            }
            for(int i=0 ; i<8 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty) && !visit[ty][tx]) {
                    visit[ty][tx] = true;
                    queue.add(new Location(tx, ty, curDepth+1));
                }
            }
            queue.poll();
        }
        return result;
    }
}