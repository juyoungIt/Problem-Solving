// BOJ - 1996
// Problem Sheet - https://www.acmicpc.net/problem/1996

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[][] map;
    private static boolean[][] isMine;
    private static final int[] xi = { 0, -1, -1, -1, 0, 1, 1, 1 };
    private static final int[] yi = { -1, -1, 0, 1, 1, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        isMine = new boolean[n][n];
        for (int i=0 ; i<n ; i++) {
            String[] row = br.readLine().split("");
            for (int j=0 ; j<n ; j++) {
                char status = row[j].charAt(0);
                if (Character.isDigit(status)) {
                    updateCountInfo(j, i, Character.getNumericValue(status));
                    isMine[i][j] = true;
                }
            }
        }

        for (int i=0 ; i<n ; i++) {
            for (int j=0 ; j<n ; j++) {
                if (isMine[i][j]) {
                    sb.append('*');
                } else {
                    if (map[i][j] >= 10) sb.append('M');
                    else sb.append(map[i][j]);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void updateCountInfo(int x, int y, int c) {
        for (int i=0 ; i<8 ; i++) {
            int curX = x + xi[i];
            int curY = y + yi[i];
            if (!isValid(curX, curY, n)) continue;
            map[curY][curX] += c;
        }
    }

    private static boolean isValid(int x, int y, int n) {
        return 0<=x && x<n && 0<=y && y<n;
    }
}
