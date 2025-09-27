// BOJ - 2669
// Problem Sheet - https://www.acmicpc.net/problem/2669

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] board = new boolean[101][101];
        int area = 0;
        for (int i=0 ; i<4 ; i++) {
            String[] row = br.readLine().split(" ");
            int ldx = Integer.parseInt(row[0]);
            int ldy = Integer.parseInt(row[1]);
            int rtx = Integer.parseInt(row[2]);
            int rty = Integer.parseInt(row[3]);
            for (int y=ldy ; y<rty ; y++) {
                for (int x=ldx ; x<rtx ; x++) {
                    if (!board[y][x]) {
                        area++;
                        board[y][x] = true;
                    }
                }
            }
        }
        System.out.println(area);
        br.close();
    }
}