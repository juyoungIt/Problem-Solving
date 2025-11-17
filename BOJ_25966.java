// BOJ - 25966
// Problem Sheet - https://www.acmicpc.net/problem/25966

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0 ; j<m ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int x=0 ; x<q ; x++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            if (c == 0) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            } else {
                int[] tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<n ; i++) {
            for (int j=0 ; j<m ; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
