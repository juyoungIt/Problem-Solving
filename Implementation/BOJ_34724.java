// BOJ - 34724
// Problem Sheet - https://www.acmicpc.net/problem/34724

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] xray = new boolean[n][m];
        for (int i=0 ; i<n ; i++) {
            String row = br.readLine();
            for (int j=0 ; j<m ; j++) {
                xray[i][j] = row.charAt(j) == '1';
            }
        }
        br.close();
        boolean isTumor = false;
        for (int i=0 ; i<n-1 ; i++) {
            for (int j=0 ; j<m-1 ; j++) {
                if (xray[i][j] && xray[i][j + 1] && xray[i + 1][j] && xray[i + 1][j + 1]) {
                    isTumor = true;
                    break;
                }
            }
        }
        System.out.println(isTumor ? 1 : 0);
    }
}
