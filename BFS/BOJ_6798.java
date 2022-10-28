// BOJ - 6798
// Problem Sheet - https://www.acmicpc.net/problem/6798

import java.util.*;
import java.io.*;

class Location {
    private final int x; // x좌표
    private final int y; // y좌표
    private final int d; // 탐색의 depth

    public Location(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public int getD() { return this.d; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Queue<Location> queue = new LinkedList<>(); // bfs에 사용하는 queue
        boolean[][] visit = new boolean[8+1][8+1]; // 방문여부
        int[] xi = {-1, -2, -2, -1, 1, 2, 2, 1}; // x-increment
        int[] yi = {-2, -1, 1, 2, 2, 1, -1, -2}; // y-increment
        int answer = 0;

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int targetX = Integer.parseInt(st.nextToken());
        int targetY = Integer.parseInt(st.nextToken());

        visit[startY][startX] = true;
        queue.add(new Location(startX, startY, 0));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            int curD = queue.peek().getD();
            if(curX == targetX && curY == targetY) {
                answer = curD;
                break;
            }
            for(int i=0 ; i<8 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, 8) && !visit[ty][tx]) {
                    visit[ty][tx] = true;
                    queue.add(new Location(tx, ty, curD+1));
                }
            }
            queue.poll();
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    static boolean validation(int x, int y, int n) { return (x>0 && y>0 && x<=n && y<=n); }
}