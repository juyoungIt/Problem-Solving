// BOJ - 17232
// Problem Sheet - https://www.acmicpc.net/problem/17232

import java.util.*;
import java.io.*;

public class Main {

    private static int N, M, T;
    private static int K, a, b;
    private static char[][] board;
    private static int[][] lives;

    public static void main(String[] args) throws IOException {
        getInput();
        while (T-- > 0) {
            updateLives();
            updateBoard();
        }
        System.out.println(getBoardStatus());
    }

    private static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        board = new char[N + 1][M + 1];
        lives = new int[N + 1][M + 1];
        for (int i=1 ; i<=N ; i++) {
            char[] row = br.readLine().toCharArray();
            System.arraycopy(row, 0, board[i], 1, M);
        }

        br.close();
    }

    private static void updateLives() {
        for (int i=1 ; i<=N ; i++) {
            for (int j=1 ; j<=M ; j++) {
                lives[i][j] = lives[i - 1][j]
                        + lives[i][j - 1]
                        - lives[i - 1][j - 1]
                        + (board[i][j] == '*' ? 1 : 0);
            }
        }
    }

    private static void updateBoard() {
        for (int i=1 ; i<=N ; i++) {
            for (int j=1 ; j<=M ; j++) {
                int aroundLives = getAroundLives(i, j);
                if (board[i][j] == '*') {
                    if (aroundLives >= a && aroundLives <= b) {
                        board[i][j] = '*';
                    } else {
                        board[i][j] = '.';
                    }
                } else {
                    if (aroundLives > a && aroundLives <= b) {
                        board[i][j] = '*';
                    }
                }
            }
        }
    }

    private static int getAroundLives(int x, int y) {
        int x1 = Math.max(1, x - K);
        int y1 = Math.max(1, y - K);
        int x2 = Math.min(N, x + K);
        int y2 = Math.min(M, y + K);
        return lives[x2][y2]
                - lives[x2][y1 - 1]
                - lives[x1 - 1][y2]
                + lives[x1 - 1][y1 - 1]
                - (board[x][y] == '*' ? 1 : 0);
    }

    private static String getBoardStatus() {
        StringBuilder sb = new StringBuilder();
        for (int i=1 ; i<=N ; i++) {
            for (int j=1 ; j<=M ; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}