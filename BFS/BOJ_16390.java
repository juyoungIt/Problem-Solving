// BOJ - 16390
// Problem Sheet - https://www.acmicpc.net/problem/16390

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
        int answer = 0;

        int m = Integer.parseInt(st.nextToken()); // 세로의 길이
        int n = Integer.parseInt(st.nextToken()); // 가로의 길이
        char[][] image = new char[m][n]; // 이미지의 상태 저장
        for(int i=0 ; i<m ; i++) {
            String tmp = bf.readLine();
            for(int j=0 ; j<tmp.length() ; j++)
                image[i][j] = tmp.charAt(j);
        }

        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(image[i][j] == '#') {
                    bfs(image, j, i);
                    answer++;
                }
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    static void bfs(char[][] image, int startX, int startY) {
        Queue<Location> queue = new LinkedList<>();
        int[] xi = {-1, 1, 0, 0, -1, 1, -1, 1}; // x-increment
        int[] yi = {0, 0, -1, 1, -1, -1, 1, 1}; // y-increment

        image[startY][startX] = 'X';
        queue.add(new Location(startX, startY));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<8 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, image[0].length, image.length) && image[ty][tx] == '#') {
                    image[ty][tx] = 'X';
                    queue.add(new Location(tx, ty));
                }
            }
            queue.poll();
        }
    }

    static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=0 && y>=0 && x<xLimit && y<yLimit);
    }
}