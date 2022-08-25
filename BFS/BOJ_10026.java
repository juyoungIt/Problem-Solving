// BOJ - 10026
// Problem Sheet - https://www.acmicpc.net/problem/10026

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
        int n = Integer.parseInt(bf.readLine()); // 그림의 크기
        char[][] origin = new char[n][n];    // 원본 그림
        char[][] distorted = new char[n][n]; // 적록색약 관점에서 바라본 그림
        int[] answers = new int[2]; // 정답을 저장

        for(int i=0 ; i<n ; i++) {
            String tmp = bf.readLine();
            for(int j=0 ; j<n ; j++) {
                origin[i][j] = tmp.charAt(j);
                distorted[i][j] = (origin[i][j] == 'G') ? 'R' : origin[i][j];
            }
        }

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(origin[i][j] != 'F') {
                    bfs(origin, j, i, origin[i][j]);
                    answers[0]++;
                }
                if(distorted[i][j] != 'F') {
                    bfs(distorted, j, i, distorted[i][j]);
                    answers[1]++;
                }
            }
        }

        for(int answer : answers)
            System.out.print(answer + " ");
        System.out.println();

        bf.close();
        System.exit(0);
    }

    public static void bfs(char[][] painting, int startX, int startY, char identifier) {
        Queue<Location> queue = new LinkedList<>(); // bfs를 위한 queue
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment
        painting[startY][startX] = 'F';
        queue.add(new Location(startX, startY));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, painting.length) && painting[ty][tx] == identifier) {
                    painting[ty][tx] = 'F';
                    queue.add(new Location(tx, ty));
                }
            }
            queue.poll();
        }
    }

    public static boolean validation(int x, int y, int n) {
        return (x>=0 && y>=0 && x<n && y<n);
    }
}