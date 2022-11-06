// BOJ - 4993
// Problem Sheet - https://www.acmicpc.net/problem/4993

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
        List<Integer> answers = new ArrayList<>(); // 정답 저장
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(bf.readLine());
            int w = Integer.parseInt(st.nextToken()); // room의 가로
            int h = Integer.parseInt(st.nextToken()); // room의 세로
            if(w == 0 && h == 0) break;
            int startX = 0, startY = 0;
            char[][] room = new char[h][w]; // 방의 상태 저장

            for(int i=0 ; i<h ; i++) {
                String tmp = bf.readLine();
                for(int j=0 ; j<w ; j++) {
                    room[i][j] = tmp.charAt(j);
                    if(room[i][j] == '@') {
                        startX = j;
                        startY = i;
                    }
                }
            }
            answers.add(bfs(room, startX, startY));
        }

        for(int answer : answers)
            System.out.println(answer + " ");

        bf.close();
        System.exit(0);
    }

    static int bfs(char[][] room, int startX, int startY) {
        Queue<Location> queue = new LinkedList<>(); // bfs에 사용하는 queue
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment
        int count = 0;

        room[startY][startX] = 'X';
        queue.add(new Location(startX, startY));
        count++;
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<4; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, room[0].length, room.length) && room[ty][tx] == '.') {
                    room[ty][tx] = 'X';
                    queue.add(new Location(tx, ty));
                    count++;
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