// BOJ - 9437
// Problem Sheet - https://www.acmicpc.net/problem/9437

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            int p = Integer.parseInt(st.nextToken());
            int[][] pageIndexes = new int[4][n / 4];
            for (int i=0 ; i<n/4 ; i++) {
                pageIndexes[0][i] = 1 + 2 * i;
                pageIndexes[1][i] = 2 + 2 * i;
                pageIndexes[2][i] = n - (1 + 2 * i);
                pageIndexes[3][i] = n - (2 * i);
            }
            int[] result = findPageIndex(pageIndexes, p);
            for (int i=0 ; i<4 ; i++) {
                if (i != result[0]) {
                    sb.append(pageIndexes[i][result[1]]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static int[] findPageIndex(int[][] pageIndexes, int pageNumber) {
        int[] result = new int[2];
        for (int i=0 ; i<4 ; i++) {
            for (int j=0 ; j<pageIndexes[0].length ; j++) {
                if (pageIndexes[i][j] == pageNumber) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}