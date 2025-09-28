// BOJ - 2740
// Problem Sheet - https://www.acmicpc.net/problem/2740

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] row = br.readLine().split(" ");
        int n = Integer.parseInt(row[0]);
        int m = Integer.parseInt(row[1]);
        int[][] matrixA = new int[n][m];
        for (int i=0 ; i<n ; i++) {
            row = br.readLine().split(" ");
            for (int j=0 ; j<m ; j++) {
                matrixA[i][j] = Integer.parseInt(row[j]);
            }
        }
        row = br.readLine().split(" ");
        int k = Integer.parseInt(row[1]);
        int[][] matrixB = new int[m][k];
        for (int i=0 ; i<m ; i++) {
            row = br.readLine().split(" ");
            for (int j=0 ; j<k ; j++) {
                matrixB[i][j] = Integer.parseInt(row[j]);
            }
        }

        for (int i=0 ; i<n ; i++) {
            for (int j=0 ; j<k ; j++) {
                int product = 0;
                for (int l=0 ; l<m ; l++) {
                    product += matrixA[i][l] * matrixB[l][j];
                }
                sb.append(product).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}