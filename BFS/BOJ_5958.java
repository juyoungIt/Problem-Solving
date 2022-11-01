// BOJ - 5958
// Problem Sheet - https://www.acmicpc.net/problem/5958

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
        int n = Integer.parseInt(bf.readLine()); // 우주의 크기
        char[][] space = new char[n][n]; // 우주의 상태
        boolean[][] visit = new boolean[n][n]; // 방문여부
        int answer = 0;

        for(int i=0 ; i<n ; i++) {
            String tmp = bf.readLine();
            for(int j=0 ; j<n ; j++)
                space[i][j] = tmp.charAt(j);
        }

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(space[i][j] == '*' && !visit[i][j]) {
                    bfs(space, visit, j, i);
                    answer++;
                }
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    static void bfs(char[][] space, boolean[][] visit, int startX, int startY) {
        Queue<Location> queue = new LinkedList<>(); // bfs에 사용하는 queue
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment

        visit[startY][startX] = true;
        queue.add(new Location(startX, startY));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, space.length) && space[ty][tx] == '*' && !visit[ty][tx]) {
                    visit[ty][tx] = true;
                    queue.add(new Location(tx, ty));
                }
            }
            queue.poll();
        }
    }

    static boolean validation(int x, int y, int n) {
        return (x>=0 && y>=0 && x<n && y<n);
    }
}