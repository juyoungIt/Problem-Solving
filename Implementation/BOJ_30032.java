// BOJ - 30032
// Problem Sheet - https://www.acmicpc.net/problem/30032

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][n];
        for (int i=0 ; i<n ; i++) {
            String row = br.readLine();
            for (int j=0 ; j<n ; j++) {
                board[i][j] = row.charAt(j);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char[] row : board) {
            for (char c : row) {
                sb.append(reverse(c, d));
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static char reverse(char c, int d) {
        if (d == 1) {
            if (c == 'd') return 'q';
            else if (c == 'b') return 'p';
            else if (c == 'q') return 'd';
            else if (c == 'p') return 'b';
            else throw new IllegalArgumentException("invalid character...");
        } else if (d == 2) {
            if (c == 'd') return 'b';
            else if (c == 'b') return 'd';
            else if (c == 'q') return 'p';
            else if (c == 'p') return 'q';
            else throw new IllegalArgumentException("invalid character...");
        } else {
            throw new IllegalArgumentException("invalid direction");
        }
    }
}
