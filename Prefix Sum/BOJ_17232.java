// BOJ - 17232
// Problem Sheet - https://www.acmicpc.net/problem/17232

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int k = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] board = new int[n+1][m+1];
        int[][] accBoard = new int[n+1][m+1];
        for(int i=1 ; i<=n ; i++) {
            char[] rows = bf.readLine().toCharArray();
            for(int j=1 ; j<=m ; j++) {
                if(rows[j-1] == '*') {
                    board[i][j] = 1;
                }
            }
        }

        while(t-- > 0) {
            for(int i=1 ; i<=n ; i++) {
                for(int j=1 ; j<=m ; j++) {
                    accBoard[i][j] = accBoard[i-1][j] + accBoard[i][j-1] - accBoard[i-1][j-1] + board[i][j];
                }
            }

            for(int i=1 ; i<=n ; i++) {
                for(int j=1 ; j<=m ; j++) {
                    int x1 = Math.max(1, j-k);
                    int y1 = Math.max(1, i-k);
                    int x2 = Math.min(m, j+k);
                    int y2 = Math.min(n, i+k);
                    int curLifeCount = accBoard[y2][x2] - accBoard[y1-1][x2] - accBoard[y2][x1-1] + accBoard[y1-1][x1-1];

                    if(board[i][j] == 1) {
                        curLifeCount--;
                        if(curLifeCount < a || curLifeCount > b) {
                            board[i][j] = 0;
                        }
                    } else {
                        if(curLifeCount > a && curLifeCount <= b) {
                            board[i][j] = 1;
                        }
                    }
                }
            }
        }

        for(int i=1 ; i<=n ; i++) {
            for(int j=1 ; j<=m ; j++) {
                sb.append(board[i][j] == 1 ? '*' : '.');
            }
            sb.append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}