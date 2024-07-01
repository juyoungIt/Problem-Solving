// BOJ - 2167
// Problem Sheet - https://www.acmicpc.net/problem/2167

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] acc = new int[n + 1][m + 1];
        for (int i=1 ; i<=n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1 ; j<=m ; j++) {
                acc[i][j] = acc[i-1][j] + acc[i][j-1] - acc[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        int k = Integer.parseInt(br.readLine());
        for (int i=0 ; i<k ; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(acc[x2][y2] - acc[x1-1][y2] - acc[x2][y1-1] + acc[x1-1][y1-1]).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}