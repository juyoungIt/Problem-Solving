// BOJ - 6031
// Problem Sheet - https://www.acmicpc.net/problem/6031

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

        int w = Integer.parseInt(st.nextToken()); // 농장의 가로길이
        int h = Integer.parseInt(st.nextToken()); // 농장의 세로길이
        char[][] farm = new char[h][w]; // 농장의 상태정보 저장
        for(int i=0 ; i<h ; i++) {
            String tmp = bf.readLine();
            for(int j=0 ; j<w ; j++)
                farm[i][j] = tmp.charAt(j);
        }

        for(int i=0 ; i<h ; i++)
            for(int j=0 ; j<w ; j++)
                if(farm[i][j] == '.')
                    answer = Math.max(answer, eatGrass(farm, j, i));

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    static int eatGrass(char[][] farm, int startX, int startY) {
        Queue<Location> queue = new LinkedList<>();
        int[] xi = {-1, 1, 0, 0, -1, -1, 1, 1}; // x-increment
        int[] yi = {0, 0, -1, 1, -1, 1, -1, 1}; // y-increment
        int count = 0;

        count++;
        farm[startY][startX] = 'X';
        queue.add(new Location(startX, startY));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<8 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, farm[0].length, farm.length) && farm[ty][tx] == '.') {
                    count++;
                    farm[ty][tx] = 'X';
                    queue.add(new Location(tx, ty));
                }
            }
            queue.poll();
        }
        return count;
    }

    static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=0 && y>=0 && x<xLimit && y<yLimit);
    }
}