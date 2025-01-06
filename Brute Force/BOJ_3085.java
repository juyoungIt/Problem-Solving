// BOJ - 3085
// Problem Sheet - https://www.acmicpc.net/problem/3085

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];
        for (int i=0 ; i<N ; i++) {
            String row = br.readLine();
            for (int j=0 ; j<N ; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        System.out.println(Math.max(getTotalRowMaxLen(board, N), getTotalColMaxLen(board, N)));
        br.close();
    }

    private static void swap(char[][] board, int x1, int y1, int x2, int y2) {
        char tmp = board[y1][x1];
        board[y1][x1] = board[y2][x2];
        board[y2][x2] = tmp;
    }

    private static int getTotalRowMaxLen(char[][] board, int N) {
        int maxLen = 0;
        for (int i=0 ; i<N ; i++) {
            for (int j=0 ; j<N-1 ; j++) {
                swap(board, j, i, j + 1, i);
                maxLen = Math.max(maxLen, getRowMaxLen(board, N, i));
                maxLen = Math.max(maxLen, getColMaxLen(board, N, j));
                maxLen = Math.max(maxLen, getColMaxLen(board, N, j + 1));
                swap(board, j, i, j + 1, i);
            }
        }
        return maxLen;
    }

    private static int getTotalColMaxLen(char[][] board, int N) {
        int maxLen = 0;
        for (int i=0 ; i<N ; i++) {
            for (int j=0 ; j<N-1 ; j++) {
                swap(board, i, j, i, j + 1);
                maxLen = Math.max(maxLen, getColMaxLen(board, N, i));
                maxLen = Math.max(maxLen, getRowMaxLen(board, N, j));
                maxLen = Math.max(maxLen, getRowMaxLen(board, N, j + 1));
                swap(board, i, j, i, j + 1);
            }
        }
        return maxLen;
    }

    private static int getRowMaxLen(char[][] board, int N, int rowIdx) {
        int maxLen = 0;
        int curLen = 1;
        for (int i=1 ; i<N ; i++) {
            if (board[rowIdx][i - 1] == board[rowIdx][i]) {
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = 1;
            }
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }

    private static int getColMaxLen(char[][] board, int N, int colIdx) {
        int maxLen = 0;
        int curLen = 1;
        for (int i=1 ; i<N ; i++) {
            if (board[i - 1][colIdx] == board[i][colIdx]) {
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = 1;
            }
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }

}