// BOJ - 1012
// Problem Sheet - https://www.acmicpc.net/problem/1012

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

        int tcSize = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수
        int[][] map = new int[50][50]; // 공유해서 사용하기 위한 지도
        int[] answers = new int[tcSize]; // 정답을 저장하는 배열
        for(int i=0 ; i<tcSize ; i++) {
            st = new StringTokenizer(bf.readLine());
            int m = Integer.parseInt(st.nextToken()); // 밭의 가로 길이
            int n = Integer.parseInt(st.nextToken()); // 밭의 세로 길이
            int k = Integer.parseInt(st.nextToken()); // 배추의 수
            for(int j=0 ; j<k ; j++) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken()); // 배추 위치의 x좌표
                int y = Integer.parseInt(st.nextToken()); // 배추 위치의 y좌표
                map[y][x] = 1;
            }
            int count = 0; // 필요한 배추흰지렁이의 수

            for(int j=0 ; j<n ; j++) {
                for(int l=0 ; l<m ; l++) {
                    if(map[j][l] == 1) {
                        bfs(map, l, j, m, n);
                        count++;
                    }
                }
            }
            answers[i] = count;
            // 재사용을 위해 공유하는 요소를 초기화
            for(int j=0 ; j<n ; j++)
                Arrays.fill(map[j], 0);
        }

        for(int answer : answers)
            System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    public static void bfs(int[][] map, int startX, int startY, int width, int height) {
        Queue<Location> queue = new LinkedList<>(); // bfs를 위한 queue
        int[] xi = {-1, 1, 0, 0};
        int[] yi = {0, 0, -1, 1};

        map[startY][startX] = 2;
        queue.add(new Location(startX, startY));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, width, height) && map[ty][tx] == 1) {
                    map[ty][tx] = 2;
                    queue.add(new Location(tx, ty));
                }
            }
            queue.poll();
        }
    }

    public static boolean validation(int x, int y, int xLimit, int yLimit) {
        if(x<0 || y<0 || x>xLimit-1 || y>yLimit-1)
            return false;
        return true;
    }
}