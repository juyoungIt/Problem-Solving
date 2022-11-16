// BOJ - 1932
// Problem Sheet - https://www.acmicpc.net/problem/1932

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine()); // 삼각형의 크기
        int[][] triangle = new int[n][n]; // 삼각형의 상태를 저장

        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            if(i == 0) triangle[i][0] = Integer.parseInt(st.nextToken());
            else {
                for(int j=0 ; j<i+1 ; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    if(j == 0)
                        triangle[i][j] = triangle[i-1][j] + value;
                    else if(j == i)
                        triangle[i][j] = triangle[i-1][j-1] + value;
                    else
                        triangle[i][j] = Math.max(triangle[i-1][j] + value, triangle[i-1][j-1] + value);
                }
            }
        }

        Arrays.sort(triangle[n-1]);
        System.out.println(triangle[n-1][n-1]);

        bf.close();
        System.exit(0);
    }
}