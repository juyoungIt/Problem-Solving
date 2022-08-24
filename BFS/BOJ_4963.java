// BOJ - 4963
// Problem Sheet - https://www.acmicpc.net/problem/4963

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
        ArrayList<Integer> answers = new ArrayList<>(); // 각 테스트 케이스의 정답을 저장

        while(true) {
            st = new StringTokenizer(bf.readLine());
            int w = Integer.parseInt(st.nextToken()); // 지도의 너비
            int h = Integer.parseInt(st.nextToken()); // 지도의 높이
            int answer = 0; // 섬의 개수

            if(w ==0 && h == 0) break;
            int[][] map = new int[h][w]; // 섬의 정보를 그려줄 지도
            for(int i=0 ; i<h ; i++) {
                st = new StringTokenizer(bf.readLine());
                for(int j=0 ; j<w ; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            for(int i=0 ; i<h ; i++) {
                for(int j=0 ; j<w ; j++) {
                    if(map[i][j] == 1) {
                        bfs(map, j, i);
                        answer++; // 섬의 갯수를 카운트
                    }
                }
            }
            answers.add(answer);
        }

        // 각 테스트 케이스의 정답을 출력
        for(int answer : answers)
            System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    public static void bfs(int[][] map, int startX, int startY) {
        Queue<Location> queue = new LinkedList<>(); // bfs를 위한 queue
        int[] xi = {-1, 0, 1, -1, 1, -1, 0, 1}; // x-increment
        int[] yi = {-1, -1, -1, 0, 0, 1, 1, 1}; // y-increment

        map[startY][startX] = 2;
        queue.add(new Location(startX, startY));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<8 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, map[0].length, map.length) && map[ty][tx] == 1) {
                    map[ty][tx] = 2;
                    queue.add(new Location(tx, ty));
                }
            }
            queue.poll();
        }
    }

    public static boolean validation(int x, int y, int xLimit, int yLimit) {
        return x>=0 && y>= 0 && x<xLimit && y<yLimit;
    }
}