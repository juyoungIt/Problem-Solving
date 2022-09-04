// BOJ - 14716
// Problem Sheet - https://www.acmicpc.net/problem/14716

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

        int m = Integer.parseInt(st.nextToken()); // 현수막 세로의 길이
        int n = Integer.parseInt(st.nextToken()); // 현수막 가로의 길이
        int[][] banner = new int[m][n]; // 현수막
        int answer = 0;

        // 입력으로부터 banner를 구성함
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<n ; j++)
                banner[i][j] = Integer.parseInt(st.nextToken());
        }

        // 글자의 수를 카운트함
        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(banner[i][j] == 1) {
                    bfs(banner, j, i);
                    answer++;
                }
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    public static void bfs(int[][] banner, int startX, int startY) {
        Queue<Location> queue = new LinkedList<>(); // bfs에 사용하기 위한 queue
        int[] xi = {-1, 0, 1, 1, 1, 0, -1, -1}; // x-increment
        int[] yi = {-1, -1, -1, 0, 1, 1, 1, 0}; // y-increment

        banner[startY][startX] = 2;
        queue.add(new Location(startX, startY));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<8 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, banner[0].length, banner.length) && banner[ty][tx] == 1) {
                    banner[ty][tx] = 2;
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