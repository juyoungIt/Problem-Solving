// BOJ - 3184
// Problem Sheet - https://www.acmicpc.net/problem/3184

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
        int[] servived = new int[2]; // 살아남은 양과 늑대의 수 (0 - 양, 1 - 늑대)

        int r = Integer.parseInt(st.nextToken()); // 마당의 세로 길이
        int c = Integer.parseInt(st.nextToken()); // 마당의 가로 길이
        char[][] map = new char[r][c]; // 양과 늑대의 정보를 표시할 지도
        // 입력된 정보를 바탕으로 지도를 구성함
        for(int i=0 ; i<r ; i++) {
            String tmp = bf.readLine();
            for(int j=0 ; j<c ; j++)
                map[i][j] = tmp.charAt(j);
        }

        // bfs를 수행하며 양과 늑대의 수를 카운트 함
        for(int i=0 ; i<r ; i++)
            for(int j=0 ; j<c ; j++)
                bfs(map, j, i, servived);

        // 최종 솔루션 출력
        for(int answer : servived)
            System.out.print(answer + " ");
        System.out.println();

        bf.close();
        System.exit(0);
    }

    public static void bfs(char[][] map, int startX, int startY, int[] servived) {
        Queue<Location> queue = new LinkedList<>(); // bfs를 위한 queue
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment
        int sheep = 0; // 해당 구역 내의 양의 수
        int wolf = 0;  // 해당 구역 내의 늑대의 수

        map[startY][startX] = 'x'; // 지난 구역임을 표시
        queue.add(new Location(startX, startY));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, map[0].length, map.length) && map[ty][tx] != 'x' && map[ty][tx] != '#') {
                    if(map[ty][tx] == 'o')
                        sheep++;
                    else if(map[ty][tx] == 'v')
                        wolf++;
                    map[ty][tx] = 'x';
                    queue.add(new Location(tx, ty));
                }
            }
            queue.poll();
        }
        if(sheep > wolf) servived[0] += sheep;
        else servived[1] += wolf;
    }

    public static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=0 && y>=0 && x<xLimit && y<yLimit);
    }
}