// BOJ - 18404
// Problem Sheet - https://www.acmicpc.net/problem/18404

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
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken()); // 보드의 크기
        int m = Integer.parseInt(st.nextToken()); // 적말의 수
        int[][] board = new int[n+1][n+1]; // 보드의 상태를 저장
        int[] answers = new int[m]; // 각 말에 도달하는 대 필요한 최소이동횟수를 저장
        int startX = 0, startY = 0; // 탐색의 시작지점

        for(int i=0 ; i<=m ; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(i == 0) {
                startX = a;
                startY = b;
            }
            else board[a][b] = i;
        }

        bfs(board, answers, startX, startY); // bfs 수행
        for(int answer : answers)
            System.out.print(answer + " ");
        System.out.println();

        bf.close();
        System.exit(0);
    }

    static void bfs(int[][] board, int[] answers, int startX, int startY) {
        Queue<Location> queue = new LinkedList<>();
        int[] xi = {-2, -2, -1, -1, 1, 1, 2, 2}; // x-increment
        int[] yi = {-1, 1, -2, 2, -2, 2, -1, 1}; // y-increment

        board[startX][startY] = -1;
        queue.add(new Location(startX, startY, 0));
        while(!queue.isEmpty()) {
            int curX = queue.peek().getX();
            int curY = queue.peek().getY();
            int curD = queue.peek().getD();
            for(int i=0 ; i<8 ; i++) {
                int tx = curX + xi[i];
                int ty = curY + yi[i];
                if(validation(tx, ty, board.length-1) && board[tx][ty] > -1) {
                    if(board[tx][ty] > 0)
                        answers[board[tx][ty]-1] = curD+1;
                    board[tx][ty] = -1;
                    queue.add(new Location(tx, ty, curD+1));
                }
            }
            queue.poll();
        }
    }

    static boolean validation(int x, int y, int n) { return (x>=1 && y>=1 && x<=n && y<=n); }
}