// BOJ - 16948
// Problem Sheet - https://www.acmicpc.net/problem/16948

import java.util.*;
import java.io.*;

class Location {
    private final int x;
    private final int y;
    private final int depth;

    public Location(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public int getDepth() { return this.depth; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 체스판의 크기
        boolean[][] board = new boolean[n][n]; // 체스판 (방문정보)
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Queue<Location> queue = new LinkedList<>(); // bfs를 수행하는 데 필요한 queue
        int[] xi = {-2, -2, 0, 0, 2, 2}; // x-increment
        int[] yi = {-1, 1, -2, 2, -1, 1}; // y-increment
        boolean isReached = false;
        int answer = -1; // 도달할 수 있는 횟수

        // 좌표정보를 입력받아 구성함
        int[] start = new int[2];  // 시작좌표
        int[] target = new int[2]; // 목표좌표
        for(int i=0 ; i<2 ; i++)
            start[i] = Integer.parseInt(st.nextToken());
        for(int i=0 ; i<2 ; i++)
            target[i] = Integer.parseInt(st.nextToken());

        // bfs를 수행하며 목표한 지점을 탐색함
        board[start[1]][start[0]] = true;
        queue.add(new Location(start[0], start[1], 0));
        while(!queue.isEmpty()) {
            if(isReached) break;
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            int curDepth = queue.peek().getDepth();
            for(int i=0 ; i<6 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, n) && !board[ty][tx]) {
                    if(tx == target[0] && ty == target[1]) {
                        answer = curDepth + 1;
                        isReached = true;
                        break;
                    }
                    board[ty][tx] = true;
                    queue.add(new Location(tx, ty, curDepth+1));
                }
            }
            queue.poll();
        }

        // 탐색 간 산출된 코드를 출력함
        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    public static boolean validation(int x, int y, int n) {
        return (x>=0 && y>=0 && x<n && y<n);
    }
}