// BOJ - 1303
// Problem Sheet - https://www.acmicpc.net/problem/1303

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

        int n = Integer.parseInt(st.nextToken()); // 전쟁터 가로의 크기
        int m = Integer.parseInt(st.nextToken()); // 전쟁터 세로의 크기
        char[][] map = new char[m][n]; // 전쟁이 벌어지는 필드
        int[] powers = new int[2]; // 각 병사 진영의 위력

        for(int i=0 ; i<m ; i++) {
            String tmp = bf.readLine();
            for(int j=0 ; j<n ; j++)
                map[i][j] = tmp.charAt(j);
        }

        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(map[i][j] != 'X') {
                    if(map[i][j] == 'B') powers[0] += bfs(map, j, i, 'B');
                    else powers[1] += bfs(map, j, i, 'W');
                }
            }
        }

        System.out.println(powers[1] + " " + powers[0]);

        bf.close();
        System.exit(0);
    }

    public static int bfs(char[][] map, int startX, int startY, char target) {
        Queue<Location> queue = new LinkedList<>(); // bfs를 수행하기 위한 queue
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment
        int count = 0; // 함께 뭉쳐있는 병사들의 수

        map[startY][startX] = 'X';
        queue.add(new Location(startX, startY));
        count++;
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, map[0].length, map.length) && map[ty][tx] == target) {
                    map[ty][tx] = 'X';
                    queue.add(new Location(tx, ty));
                    count++;
                }
            }
            queue.poll();
        }
        return (int)Math.pow(count, 2);
    }

    public static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=0 && y>=0 && x<xLimit && y<yLimit);
    }
}