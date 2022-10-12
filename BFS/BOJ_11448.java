// BOJ - 11448
// Problem Sheet - https://www.acmicpc.net/problem/11448

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
        Queue<Location> queue = new LinkedList<>(); // bfs에 사용할 queue

        int t = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수
        int[] answers = new int[t]; // 각 테스트 케이스의 솔루션

        for(int i=0 ; i<t ; i++) {
            int n = Integer.parseInt(bf.readLine()); // 보드의 크기
            char[][] board = new char[n][n]; // 보드의 상태정보
            for(int j=0 ; j<n ; j++) {
                String tmp = bf.readLine();
                for(int k=0 ; k<n ; k++) {
                    board[j][k] = tmp.charAt(k);
                    if(board[j][k] == 'w')
                        queue.add(new Location(k, j));
                }
            }
            answers[i] = bfs(board, queue);
        }

        // 산출된 정답을 출력함
        for(int answer : answers)
            System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    static int bfs(char[][] board, Queue<Location> queue) {
        int[] xi = {-1, 0, 1, 1, 1, 0, -1, -1}; // x-increment
        int[] yi = {1, 1, 1, 0, -1, -1, -1, 0}; // y-increment
        int count = 0; // 놓을 수 있는 백돌의 수

        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            for(int i=0 ; i<8 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, board.length) && board[ty][tx] == '-') {
                    board[ty][tx] = 'w';
                    queue.add(new Location(tx, ty));
                    count++;
                }
            }
            queue.poll();
        }
        return count;
    }

    static boolean validation(int x, int y, int n) { return (x>=0 && y>=0 && x<n && y<n); }
}