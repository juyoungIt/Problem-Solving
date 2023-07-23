// BOJ - 1915
// Problem Sheet - https://www.acmicpc.net/problem/1915

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][m+1];
        int[][] acc = new int[n+1][m+1];
        for(int i=1 ; i<=n ; i++) {
            String[] rows = bf.readLine().split("");
            for(int j=1 ; j<=m ; j++) {
                arr[i][j] = Integer.parseInt(rows[j-1]);
                acc[i][j] = acc[i-1][j] + acc[i][j-1] - acc[i-1][j-1];
                if(arr[i][j] == 1) {
                    acc[i][j]++;
                }
            }
        }

        int min = 1;
        int max = Math.min(n, m);
        int mid;
        int maxArea = 0;
        while(min <= max) {
            mid = (min + max) / 2;
            if(squareExist(acc, mid)) {
                maxArea = mid * mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(maxArea);

        bf.close();
        System.exit(0);
    }

    private static boolean squareExist(int[][] acc, int sideLength) {
        int n = acc.length-1;
        int m = acc[0].length-1;
        for(int i=1 ; i<=n-sideLength+1 ; i++) {
            for(int j=1 ; j<=m-sideLength+1 ; j++) {
                int area = acc[i+sideLength-1][j+sideLength-1]
                        - acc[i-1][j+sideLength-1]
                        - acc[i+sideLength-1][j-1]
                        + acc[i-1][j-1];
                if(area == sideLength * sideLength) {
                    return true;
                }
            }
        }
        return false;
    }
}