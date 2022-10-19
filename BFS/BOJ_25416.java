// BOJ - 25416
// Problem Sheet - https://www.acmicpc.net/problem/25416

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
        StringTokenizer st;

        int[][] board = new int[5][5]; // 보드의 상태정보 저장
        for(int i=0 ; i<5 ; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<5 ; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        int startY = Integer.parseInt(st.nextToken()); // 시작 위치의 Y좌표
        int startX = Integer.parseInt(st.nextToken()); // 시작 위치의 X좌표

        System.out.println(bfs(board, startX, startY));

        bf.close();
        System.exit(0);
    }

    static int bfs(int[][] board, int startX, int startY) {
        Queue<Location> queue = new LinkedList<>();
        int[] xi = {-1, 1, 0, 0}; // x-increment
        int[] yi = {0, 0, -1, 1}; // y-increment
        int result = -1;

        board[startY][startX] = -1;
        queue.add(new Location(startX, startY, 0));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            int curDepth = queue.peek().getDepth();
            if(board[curY][curX] == 1) {
                result = curDepth;
                break;
            }
            for(int i=0 ; i<4 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, board[0].length, board.length) && board[ty][tx] >= 0) {
                    if(board[ty][tx] == 0) board[ty][tx] = -1;
                    queue.add(new Location(tx, ty, curDepth+1));
                }
            }
            queue.poll();
        }
        return result;
     }

    static boolean validation(int x, int y, int xLimit, int yLimit) {
        return (x>=0 && y>=0 && x<xLimit && y<yLimit);
    }
}