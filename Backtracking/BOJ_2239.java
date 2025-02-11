// BOJ - 2239
// Problem Sheet - https://www.acmicpc.net/problem/2239

import java.io.*;

public class Main {

    private static final int[][] board = new int[9][9];
    private static final boolean[][] row = new boolean[9][10];
    private static final boolean[][] col = new boolean[9][10];
    private static final boolean[][] sec = new boolean[9][10];
    private static int nextBlackX, nextBlankY;

    public static void main(String[] args) throws IOException {
        input();
        getNextBlank(0);
        solve(nextBlackX, nextBlankY);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0 ; i<9 ; i++) {
            String input = br.readLine();
            for (int j=0 ; j<9 ; j++) {
                board[i][j] = input.charAt(j) - '0';
                row[i][board[i][j]] = true;
                col[j][board[i][j]] = true;
                sec[getSectionIndex(j, i)][board[i][j]] = true;
            }
        }
        br.close();
    }

    private static void solve(int x, int y) {
        if (x == -1 && y == -1) {
            System.out.println(getBoardStatus());
            System.exit(0);
        }
        for (int i=1 ; i<=9 ; i++) {
            if (isValid(x, y, i)) {
                board[y][x] = i;
                row[y][board[y][x]] = true;
                col[x][board[y][x]] = true;
                sec[getSectionIndex(x, y)][board[y][x]] = true;
                getNextBlank(y);
                solve(nextBlackX, nextBlankY);
                sec[getSectionIndex(x, y)][board[y][x]] = false;
                col[x][board[y][x]] = false;
                row[y][board[y][x]] = false;
                board[y][x] = 0;
            }
        }
    }

    private static boolean isValid(int x, int y, int n) {
        return !row[y][n] && !col[x][n] && !sec[getSectionIndex(x, y)][n];
    }

    private static void getNextBlank(int lastY) {
        for (int i=lastY ; i<9 ; i++) {
            for (int j=0 ; j<9 ; j++) {
                if (board[i][j] == 0) {
                    nextBlackX = j;
                    nextBlankY = i;
                    return;
                }
            }
        }
        nextBlackX = -1;
        nextBlankY = -1;
    }

    private static String getBoardStatus() {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<9 ; i++) {
            for (int j=0 ; j<9 ; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static int getSectionIndex(int x, int y) {
        return y / 3 * 3 + x / 3;
    }
}