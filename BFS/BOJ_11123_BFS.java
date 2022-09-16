// BOJ - 11123
// Problem Sheet - https://www.acmicpc.net/problem/11123

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
        int[] answers = new int[tcSize]; // 각 테스트 케이스에 대한 정답을 저장

        // 각 테스트 케이스에 대하여 다음을 반복함
        for(int i=0 ; i<tcSize ; i++) {
            st = new StringTokenizer(bf.readLine());
            int h = Integer.parseInt(st.nextToken()); // 그리드의 높이
            int w = Integer.parseInt(st.nextToken()); // 그리드의 너비
            char[][] grid = new char[h][w]; // 그리드
            // 입력 정보를 바탕으로 grid를 구성함
            for(int j=0 ; j<h ; j++) {
                String tmp = bf.readLine();
                for(int k=0 ; k<w ; k++)
                    grid[j][k] = tmp.charAt(k);
            }
            // dfs를 수행하여 양 무리의 수를 카운트함
            for(int j=0 ; j<h ; j++) {
                for(int k=0 ; k<w ; k++) {
                    if(grid[j][k] == '#') {
                        bfs(grid, k, j);
                        answers[i]++;
                    }
                }
            }
        }

        // 수집된 결과를 출력함
        for(int answer : answers)
            System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    public static void bfs(char[][] grid, int startX, int startY) {
        Queue<Location> queue = new LinkedList<>(); // bfs를 수행하기 위한 queue
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment

        grid[startY][startX] = 'x';
        queue.add(new Location(startX, startY));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, grid[0].length, grid.length) && grid[ty][tx] == '#') {
                    grid[ty][tx] = 'x';
                    queue.add(new Location(tx, ty));
                }
            }
            queue.poll();
        }
    }

    public static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=0 && y>=0 && x<xLimit && y<yLimit);
    }
}