// BOJ - 3085
// Problem Sheet - https://www.acmicpc.net/problem/3085

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int maxLength = 0;

        int sizeOfBoard = Integer.parseInt(bf.readLine());
        char[][] board = new char[sizeOfBoard][sizeOfBoard];
        for(int i=0 ; i<sizeOfBoard ; i++) {
            board[i] = bf.readLine().toCharArray();
        }

        for(int i=0 ; i<sizeOfBoard ; i++) {
            for(int j=0 ; j<sizeOfBoard ; j++) {
                if(j+1<sizeOfBoard && board[i][j] != board[i][j+1]) {
                    swap(board, i, j, i, j+1);
                    maxLength = Math.max(maxLength, Math.max(getRowMax(board), getColumnMax(board)));
                    swap(board, i, j, i, j+1);
                }
                if(i+1<sizeOfBoard && board[i][j] != board[i+1][j]) {
                    swap(board, i, j, i+1, j);
                    maxLength = Math.max(maxLength, Math.max(getRowMax(board), getColumnMax(board)));
                    swap(board, i, j, i+1, j);
                }
            }
        }

        System.out.println(maxLength);

        bf.close();
        System.exit(0);
    }

    private static void swap(char[][] board, int x1, int y1, int x2, int y2) {
        char tmp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = tmp;
    }

    private static int getRowMax(char[][] board) {
        int maxLength = 0;
        for(int i=0 ; i<board.length ; i++) {
            int curLength = 1;
            for(int j=1 ; j<board.length ; j++) {
                if(board[i][j] == board[i][j-1]) {
                    curLength++;
                } else {
                    maxLength = Math.max(curLength, maxLength);
                    curLength = 1;
                }
            }
            maxLength = Math.max(curLength, maxLength);
        }
        return maxLength;
    }

    private static int getColumnMax(char[][] board) {
        int maxLength = 0;
        for(int j=0 ; j<board.length ; j++) {
            int curLength = 1;
            for(int i=1 ; i<board.length ; i++) {
                if(board[i][j] == board[i-1][j]) {
                    curLength++;
                } else {
                    maxLength = Math.max(curLength, maxLength);
                    curLength = 1;
                }
            }
            maxLength = Math.max(curLength, maxLength);
        }
        return maxLength;
    }
}