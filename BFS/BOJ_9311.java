// BOJ - 9311
// Problem Sheet - https://www.acmicpc.net/problem/9311

import java.util.*;
import java.io.*;

class Location {
    private final int x; // x좌표
    private final int y; // y좌표
    private final int d; // 탐색의 depth

    public Location(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public int getD() { return this.d; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수
        for(int i=0 ; i<t ; i++) {
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken()); // 미로의 세로길이
            int c = Integer.parseInt(st.nextToken()); // 미로의 가로길이
            char[][] maze = new char[r][c]; // 미로의 상태를 저장
            int startX = 0, startY = 0;
            for(int j=0 ; j<r ; j++) {
                String tmp = bf.readLine();
                for(int k=0 ; k<c ; k++) {
                    maze[j][k] = tmp.charAt(k);
                    if(maze[j][k] == 'S') {
                        startX = k;
                        startY = j;
                    }
                }
            }
            int result = bfs(maze, startX, startY);
            if(result > -1) System.out.println("Shortest Path: " + result);
            else System.out.println("No Exit");
        }

        bf.close();
        System.exit(0);
    }

    static int bfs(char[][] maze, int startX, int startY) {
        Queue<Location> queue = new LinkedList<>();
        boolean[][] visit = new boolean[maze.length][maze[0].length]; // 방문정보
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment
        int result = -1;

        visit[startY][startX] = true;
        queue.add(new Location(startX, startY, 0));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            int curD = queue.peek().getD();
            if(maze[curY][curX] == 'G') {
                result = curD;
                break;
            }
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, maze[0].length, maze.length) && maze[ty][tx] != 'X' && !visit[ty][tx]) {
                    visit[ty][tx] = true;
                    queue.add(new Location(tx, ty, curD+1));
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