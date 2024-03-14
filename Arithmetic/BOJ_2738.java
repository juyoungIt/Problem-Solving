// BOJ - 2738
// Problem Sheet - https://www.acmicpc.net/problem/2738

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] matrixA = new int[n][m];
        int[][] matrixB = new int[n][m];

        getMatrixValues(br, matrixA, n);
        getMatrixValues(br, matrixB, n);

        for (int i=0 ; i<n ; i++) {
            for (int j=0 ; j<m ; j++) {
                sb.append(matrixA[i][j] + matrixB[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static void getMatrixValues(BufferedReader br, int[][] matrix, int n) throws IOException {
        for (int i=0 ; i<n ; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}