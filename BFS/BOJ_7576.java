// BOJ - 7576
// Problem Sheet - https://www.acmicpc.net/problem/7576

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
        int m = Integer.parseInt(st.nextToken()); // 상자 가로 칸의 수
        int n = Integer.parseInt(st.nextToken()); // 상자 세로 칸의 수
        int[][] box = new int[n][m]; // 토마토를 담는 상자
        Queue<Location> queue = new LinkedList<>(); // bfs에 사용하는 queue
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<m ; j++) {
                box[i][j] = Integer.parseInt(st.nextToken() + "");
                if(box[i][j] == 1)
                    queue.add(new Location(j, i));
            }
        }
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment
        boolean isFinished = true;
        int answer = 0;

        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, m, n) && box[ty][tx] == 0) {
                    box[ty][tx] = box[curY][curX] + 1;
                    queue.add(new Location(tx, ty));
                }
            }
            queue.poll();
        }

        // 모든 토마토가 익었는 지에 대한 유무를 검사
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(box[i][j] == 0) {
                    isFinished = false;
                    break;
                }
                if(answer < box[i][j])
                    answer = box[i][j];
            }
        }

        System.out.println(isFinished ? answer-1 : -1); // 처음 익은 토마토 자체는 0일로 치기 때문에 1을 빼줌

        bf.close();
        System.exit(0);
    }

    public static boolean validation(int x, int y, int xLimit, int yLimit) {
        return x >= 0 && y >= 0 && x <= xLimit - 1 && y <= yLimit - 1;
    }
}