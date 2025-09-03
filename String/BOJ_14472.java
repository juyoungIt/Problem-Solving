// BOJ - 14472
// Problem Sheet - https://www.acmicpc.net/problem/14472

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int d = Integer.parseInt(input[2]);
        boolean[][] board = new boolean[n][m];
        for (int i=0 ; i<n ; i++) {
            String row = br.readLine();
            for (int j=0 ; j<m ; j++) {
                if (row.charAt(j) == '.') {
                    board[i][j] = true;
                }
            }
        }

        int candidateCount = 0;
        for (int i=0 ; i<n ; i++) {
            for (int j=0 ; j<=m-d ; j++) {
                boolean isValid = true;
                for (int k=j ; k<j+d ; k++) {
                    if (!board[i][k]) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) candidateCount++;
            }
        }

        for (int i=0 ; i<m ; i++) {
            for (int j=0 ; j<=n-d ; j++) {
                boolean isValid = true;
                for (int k=j ; k<j+d ; k++) {
                    if (!board[k][i]) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) candidateCount++;
            }
        }

        System.out.println(candidateCount);
        br.close();
    }
}