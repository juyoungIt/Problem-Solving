// BOJ - 1987
// Problem Sheet - https://www.acmicpc.net/problem/1987

import java.io.*;

public class Main {

    private static int R, C;
    private static char[][] board;
    private static final int[] xi = { -1, 1, 0, 0 };
    private static final int[] yi = { 0, 0, -1, 1 };
    private static final boolean[] isUsed = new boolean[26];
    private static int maxDepth = 0;

    public static void main(String[] args) throws IOException {
        input();
        isUsed[board[0][0] - 'A'] = true;
        solve(0, 0, 1);
        System.out.println(maxDepth);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        R = Integer.parseInt(row[0]);
        C = Integer.parseInt(row[1]);
        board = new char[R][C];
        for (int i=0 ; i<R ; i++) {
            row = br.readLine().split("");
            for (int j=0 ; j<C ; j++) {
                board[i][j] = row[j].charAt(0);
            }
        }
        br.close();
    }

    private static void solve(int x, int y, int depth) {
        maxDepth = Math.max(maxDepth, depth);
        for (int i=0 ; i<4 ; i++) {
            int newX = x + xi[i];
            int newY = y + yi[i];
            if (isValid(newX, newY)) {
                if (!isUsed[board[newY][newX] - 'A']) {
                    isUsed[board[newY][newX] - 'A'] = true;
                    solve(newX, newY, depth + 1);
                    isUsed[board[newY][newX] - 'A'] = false;
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<C && y<R;
    }
}