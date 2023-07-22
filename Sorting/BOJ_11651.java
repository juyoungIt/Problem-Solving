// BOJ - 11651
// Problem Sheet - https://www.acmicpc.net/problem/11651

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        int[][] arr = new int[N][2];
        for(int i=0 ; i<N ; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<2 ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr, (c1, c2) -> {
            if(c1[1] == c2[1]) {
                return c1[0] - c2[0];
            }
            return c1[1] - c2[1];
        });

        for(int i=0 ; i<N ; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }
        System.out.println(sb);


        bf.close();
        System.exit(0);
    }
}