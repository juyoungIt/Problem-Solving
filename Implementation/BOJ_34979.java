// BOJ - 34979
// Problem Sheet - https://www.acmicpc.net/problem/34979

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[][] stress = new int[5][n + 1];
        int[] xi = { 0, 0, -1, 1 };
        int[] yi = { -1, 1, 0, 0 };
        for (int i=0 ; i<q ; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                stress[a][b]++;
                for (int j=0 ; j<4 ; j++) {
                    int nf = a + yi[j];
                    int nc = b + xi[j];
                    if (!isValid(nf, nc, n)) continue;
                    stress[nf][nc]++;
                }
            } else if (cmd == 2) {
                int a = Integer.parseInt(st.nextToken());
                int max = -1, maxClass = 0;
                for (int j=1 ; j<=n ; j++) {
                    if (max < stress[a][j]) {
                        max = stress[a][j];
                        maxClass = j;
                    }
                }
                sb.append(maxClass).append("\n");
            } else {
                throw new IllegalArgumentException();
            }
        }
        int mf = 0, mc = 0;
        int max = -1;
        for (int i=1 ; i<=4 ; i++) {
            for (int j=1 ; j<=n ; j++) {
                if (max < stress[i][j]) {
                    max = stress[i][j];
                    mf = i;
                    mc = j;
                }
            }
        }
        sb.append(mf).append(" ").append(mc).append("\n");
        System.out.println(sb);
        br.close();
    }

    private static boolean isValid(int f, int c, int n) {
        return 0 < f && f <=4 && 0 < c && c <= n;
    }
}
