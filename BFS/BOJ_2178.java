// BOJ - 2178
// Problem Sheet - https://www.acmicpc.net/problem/2178

import java.io.*;
import java.util.*;

// 미로 상에서 좌표를 나타내는 클래스
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
        int n = Integer.parseInt(st.nextToken()); // 세로 길이
        int m = Integer.parseInt(st.nextToken()); // 가로 길이
        int[][] board = new int[n+1][m+1]; // 미로
        int[][] visit = new int[n+1][m+1]; // 방문여부 저장 (0: 지날 수 없음, 1: 지날 수 있고 안지남, 2: 지날 수 있고 지남)
        for(int i=1 ; i<=n ; i++) {
            String tmp = bf.readLine();
            for(int j=1 ; j<=m ; j++) {
                board[i][j] = Integer.parseInt(tmp.charAt(j-1)+"");
                visit[i][j] = Integer.parseInt(tmp.charAt(j-1)+"");
            }
        }
        Queue<Location> queue = new LinkedList<>(); // bfs를 위한 queue
        int[] xi = {0, 0, -1, 1}; // x increment
        int[] yi = {-1, 1, 0, 0}; // y increment

        // bfs를 통해 미로에 대한 솔루션을 찾음 - (1, 1에서 시작)
        queue.add(new Location(1, 1));
        visit[1][1] = 2;
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX(); // 현재 위치의 x좌표
            int curY = queue.peek().getY(); // 현재 위치의 y좌표
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, m, n) && visit[ty][tx] == 1) {
                    board[ty][tx] = board[curY][curX] + 1;
                    queue.add(new Location(tx, ty));
                    visit[ty][tx] = 2;
                }
            }
            queue.poll();
        }

        System.out.println(board[n][m]);

        bf.close();
        System.exit(0);
    }

    public static boolean validation(int x, int y, int xLimit, int yLimit) {
        if(x<1 || y<1 || x>xLimit || y>yLimit)
            return false;
        return true;
    }
}