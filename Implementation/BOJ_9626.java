// BOJ - 9626
// Problem Sheet - https://www.acmicpc.net/problem/9626

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        String[] words = new String[m];
        for (int i=0 ; i<m ; i++) {
            words[i] = br.readLine();
        }

        char[][] board = new char[m + u + d][n + l + r];
        for (int i=0 ; i<m+u+d ; i++) {
            board[i][0] = (i % 2 == 0) ? '#' : '.';
            for (int j=1 ; j<n+l+r ; j++) {
                board[i][j] = (board[i][j - 1] == '#') ? '.' : '#';
            }
        }

        for (int i=0 ; i<m ; i++) {
            String word = words[i];
            for (int j=0 ; j<n ; j++) {
                board[i + u][j + l] = word.charAt(j);
            }
        }

        for (int i=0 ; i<m+u+d ; i++) {
            for (int j=0 ; j<n+l+r ; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
