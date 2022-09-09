// BOJ - 3187
// Problem Sheet - https://www.acmicpc.net/problem/3187

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

        int r = Integer.parseInt(st.nextToken()); // 지도 세로의 길이
        int c = Integer.parseInt(st.nextToken()); // 지도 가로의 길이
        char[][] map = new char[r][c]; // 양과 늑대의 위치정보를 저장하는 지도
        int[] answers = new int[2]; // 양의 수와 늑대의 수를 저장

        for(int i=0 ; i<r ; i++) {
            String tmp = bf.readLine();
            for(int j=0 ; j<c ; j++)
                map[i][j] = tmp.charAt(j);
        }

        for(int i=0 ; i<r ; i++)
            for(int j=0 ; j<c ; j++)
                if(map[i][j] == '.' || map[i][j] == 'k' || map[i][j] == 'v')
                    bfs(map, j, i, answers);

        System.out.println(answers[0] + " " + answers[1]);

        bf.close();
        System.exit(0);
    }

    public static void bfs(char[][] map, int startX, int startY, int[] answers) {
        Queue<Location> queue = new LinkedList<>(); // bfs에 사용하기 위한 queue
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment
        int sheep = 0; // 양의 수
        int wolf = 0;  // 늑대의 수

        if(map[startY][startX] == 'k')
            sheep++;
        else if(map[startY][startX] == 'v')
            wolf++;
        map[startY][startX] = 'x';
        queue.add(new Location(startX, startY));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, map[0].length, map.length) && map[ty][tx] != 'x' && map[ty][tx] != '#') {
                    if(map[ty][tx] == 'k')
                        sheep++;
                    else if(map[ty][tx] == 'v')
                        wolf++;
                    map[ty][tx] = 'x';
                    queue.add(new Location(tx, ty));
                }
            }
            queue.poll();
        }
        if(sheep > wolf)
            answers[0] += sheep;
        else
            answers[1] += wolf;
    }

    public static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=0 && y>=0 && x<xLimit && y<yLimit);
    }
}