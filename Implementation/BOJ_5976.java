// BOJ - 5976
// Problem Sheet - https://www.acmicpc.net/problem/5976

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        br.close();
        int[][] arr = new int[n][n];
        int r = 0, c = 0;
        arr[0][0] = 1;
        int dir = 0;
        for (int i=2 ; i<=n*n ; i++) {
            if (dir == 0) {
                if (isValid(r, c + 1, n) && arr[r][c + 1] == 0) arr[r][++c] = i;
                else {
                    dir = (dir + 1) % 4;
                    i--;
                }
            } else if (dir == 1) {
                if (isValid(r + 1, c, n) && arr[r + 1][c] == 0) arr[++r][c] = i;
                else {
                    dir = (dir + 1) % 4;
                    i--;
                }
            } else if (dir == 2) {
                if (isValid(r, c - 1, n) && arr[r][c - 1] == 0) arr[r][--c] = i;
                else {
                    dir = (dir + 1) % 4;
                    i--;
                }
            } else {
                if (isValid(r - 1, c, n) && arr[r - 1][c] == 0) arr[--r][c] = i;
                else {
                    dir = (dir + 1) % 4;
                    i--;
                }
            }
        }
        for (int i=0 ; i<n ; i++) {
            for (int j=0 ; j<n ; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isValid(int r, int c, int n) {
        return r>=0 && c>=0 && r<n && c<n;
    }
}
