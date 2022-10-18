// BOJ - 15092
// Problem Sheet - https://www.acmicpc.net/problem/15092

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

        int n = Integer.parseInt(st.nextToken()); // 세로 길이
        int m = Integer.parseInt(st.nextToken()); // 가로 길이
        char[][] plate = new char[n][m]; // 배양접시의 상태
        for(int i=0 ; i<n ; i++) {
            String tmp = bf.readLine();
            for(int j=0 ; j<m ; j++)
                plate[i][j] = tmp.charAt(j);
        }

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(plate[i][j] == '#') {
                    bfs(plate, j, i);
                    answer++;
                }
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    static void bfs(char[][] plate, int startX, int startY) {
        Queue<Location> queue = new LinkedList<>(); // bfs에 사용하는 queue
        int[] xi = {-1, 1, 0, 0, -1, 1, -1, 1}; // x-increment
        int[] yi = {0, 0, -1, 1, -1, -1, 1, 1}; // y-increment

        plate[startY][startX] = 'X';
        queue.add(new Location(startX, startY));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<8 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, plate[0].length, plate.length) && plate[ty][tx] == '#') {
                    plate[ty][tx] = 'X';
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