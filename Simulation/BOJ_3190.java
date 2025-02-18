// BOJ - 3190
// Problem Sheet - https://www.acmicpc.net/problem/3190

import java.util.*;
import java.io.*;

public class Main {

    static class Body {
        private final int x;
        private final int y;

        public Body(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
    }

    private static int N, K, L;
    private static int[][] board;
    private static int[][] movements;
    private static boolean[][] isSnake;
    private static final Deque<Body> snake = new ArrayDeque<>();
    private static int direction = 3; // 뱀이 이동하는 방향정보 (0: 상, 1: 하, 2: 좌, 3: 우)
    private static int movementIndex = 0;

    public static void main(String[] args) throws IOException {
        input();
        isSnake[1][1] = true;
        snake.addFirst(new Body(1, 1));
        solve(2, 1, 0);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        isSnake = new boolean[N + 1][N + 1];
        for (int i=0 ; i<K ; i++) {
            String[] row = br.readLine().split(" ");
            int r = Integer.parseInt(row[0]);
            int c = Integer.parseInt(row[1]);
            board[r][c] = 1;
        }
        L = Integer.parseInt(br.readLine());
        movements = new int[L][2];
        for (int i=0 ; i<L ; i++) {
            String[] row = br.readLine().split(" ");
            int X = Integer.parseInt(row[0]);
            int C = row[1].charAt(0) == 'L' ? 0 : 1;
            movements[i][0] = X;
            movements[i][1] = C;
        }
        br.close();
    }

    private static void solve(int x, int y, int playTime) {
        // 1. Base Case
        if (isInvalid(x, y) || isSnake[y][x]) {
            System.out.println(playTime + 1);
            System.exit(0);
        }
        // 2. Recursive Case
        if (board[y][x] == 0) {
            Body removed = snake.removeLast();
            isSnake[removed.getY()][removed.getX()] = false;
        } else {
            board[y][x] = 0;
        }
        snake.addFirst(new Body(x, y));
        isSnake[y][x] = true;
        if (movementIndex < L && movements[movementIndex][0] == playTime + 1) {
            direction = getNextDirection(direction, movements[movementIndex][1]);
            movementIndex++;
        }
        switch (direction) {
            case 0:
                solve(x, y - 1, playTime + 1);
                break;
            case 1:
                solve(x, y + 1, playTime + 1);
                break;
            case 2:
                solve(x - 1, y, playTime + 1);
                break;
            case 3:
                solve(x + 1, y, playTime + 1);
                break;
        }
    }

    private static boolean isInvalid(int x, int y) {
        return x <= 0 || y <= 0 || x > N || y > N;
    }

    private static int getNextDirection(int curDirection, int movement) {
        if (curDirection == 0) return movement == 0 ? 2 : 3;
        else if (curDirection == 1) return movement == 0 ? 3 : 2;
        else if (curDirection == 2) return movement == 0 ? 1 : 0;
        else return movement == 0 ? 0 : 1;
    }

}