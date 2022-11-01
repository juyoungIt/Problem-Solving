// BOJ - 8061
// Problem Sheet - https://www.acmicpc.net/problem/8061

import java.util.*;
import java.io.*;

class Location {
    private final int x;     // x 좌표
    private final int y;     // y 좌표
    private final int aDist; // 누적된 거리

    public Location(int x, int y, int aDist) {
        this.x = x;
        this.y = y;
        this.aDist = aDist;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public int getAdist() { return this.aDist; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Queue<Location> queue = new LinkedList<>(); // bfs에 사용한 queue
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment

        int n = Integer.parseInt(st.nextToken());  // bitmap의 세로길이
        int m = Integer.parseInt(st.nextToken());  // bitmap의 가로길이
        int[][] distInfo = new int[n+1][m+1];      // 거리정보
        boolean[][] visit = new boolean[n+1][m+1]; // 방문정보

        // 입력정보를 바탕으로 Bitmap을 구성함
        for(int i=1 ; i<=n ; i++) {
            String tmp = bf.readLine();
            for(int j=1 ; j<=m ; j++) {
                if(Integer.parseInt(tmp.charAt(j-1)+"") == 1) {
                    visit[i][j] = true;
                    queue.add(new Location(j, i, 0));
                }
            }
        }

        // BFS를 수행하여 거리정보를 저장하는 2차원 배열을 구성함
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            int curAdist = queue.peek().getAdist();
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, m, n) && !visit[ty][tx]) {
                    int dist = curAdist+getDist(curX, curY, tx, ty);
                    visit[ty][tx] = true;
                    queue.add(new Location(tx, ty, dist));
                    distInfo[ty][tx] = dist;
                }
            }
            queue.poll();
        }

        // 종합한 결과를 출력
        for(int i=1 ; i<=n ; i++) {
            for(int j=1 ; j<=m ; j++)
                System.out.print(distInfo[i][j] + " ");
            System.out.println();
        }

        bf.close();
        System.exit(0);
    }

    static int getDist(int curX, int curY, int tx, int ty) {
        return Math.abs(curX-tx) + Math.abs(curY-ty);
    }

    static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>0 && y>0 && x<=xLimit && y<=yLimit);
    }
}