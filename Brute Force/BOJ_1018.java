// BOJ - 1018
// Problem Sheet - https://www.acmicpc.net/problem/1018

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        boolean[][] board = new boolean[N][M];
        for (int i=0 ; i<N ; i++) {
            String row = br.readLine();
            for (int j=0 ; j<M ; j++) {
                board[i][j] = row.charAt(j) == 'W';
            }
        }

        int minMissCount = N * M;
        for (int i=0 ; i<=N-8 ; i++) {
            for (int j=0 ; j<=M-8 ; j++) {
                minMissCount = Math.min(minMissCount, getMissCount(board, j, i, true));
                minMissCount = Math.min(minMissCount, getMissCount(board, j, i, false));
            }
        }

        System.out.println(minMissCount);
        br.close();
    }

    private static int getMissCount(boolean[][] board, int startX, int startY, boolean type) {
        int missCount = 0;
        for (int i=startY ; i<startY+8 ; i++) {
            boolean curStatus = i % 2 == ((type) ? 1 : 0);
            for (int j=startX ; j<startX+8 ; j++) {
                if (board[i][j] != curStatus) {
                    missCount++;
                }
                curStatus = !curStatus;
            }
        }
        return missCount;
    }
}