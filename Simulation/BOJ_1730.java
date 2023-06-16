// BOJ - 1730
// Problem Sheet - https://www.acmicpc.net/problem/1730

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int sizeOfBoard = Integer.parseInt(bf.readLine());
        int[][] board = new int[sizeOfBoard][sizeOfBoard]; // 0: 아무것도, 1: 가로, 2: 세로, 3:교차
        char[] commands = bf.readLine().toCharArray();
        int curX = 0;
        int curY = 0;
        for(char command : commands) {
            if(command == 'U' && validation(curX, curY-1, sizeOfBoard)) {
                board[curY][curX] = board[curY][curX] == 0 ? 2 : board[curY][curX] == 2 ? 2 : 3;
                board[curY-1][curX] = board[curY-1][curX] == 0 ? 2 : board[curY-1][curX] == 2 ? 2 : 3;
                curY--;
            } else if(command == 'D' && validation(curX, curY+1, sizeOfBoard)) {
                board[curY][curX] = board[curY][curX] == 0 ? 2 : board[curY][curX] == 2 ? 2 : 3;
                board[curY+1][curX] = board[curY+1][curX] == 0 ? 2 : board[curY+1][curX] == 2 ? 2 : 3;
                curY++;
            } else if(command == 'L' && validation(curX-1, curY, sizeOfBoard)) {
                board[curY][curX] = board[curY][curX] == 0 ? 1 : board[curY][curX] == 1 ? 1 : 3;
                board[curY][curX-1] = board[curY][curX-1] == 0 ? 1 : board[curY][curX-1] == 1 ? 1 : 3;
                curX--;
            } else if(command == 'R' && validation(curX+1, curY, sizeOfBoard)) {
                board[curY][curX] = board[curY][curX] == 0 ? 1 : board[curY][curX] == 1 ? 1 : 3;
                board[curY][curX+1] = board[curY][curX+1] == 0 ? 1 : board[curY][curX+1] == 1 ? 1 : 3;
                curX++;
            }
        }

        for(int[] row : board) {
            for(int status : row) {
                if(status == 0) {
                    sb.append(".");
                } else if(status == 1) {
                    sb.append("-");
                } else if(status == 2) {
                    sb.append("|");
                } else {
                    sb.append("+");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static boolean validation(int x, int y, int n) {
        return x>=0 && y>=0 && x<n && y<n;
    }
}