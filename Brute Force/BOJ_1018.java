// BOJ - 1018
// Problem Sheet - https://www.acmicpc.net/problem/1018

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[n][m];
        for (int i=0 ; i<n ; i++) {
            String row = br.readLine();
            for (int j=0 ; j<m ; j++) {
                map[i][j] = (row.charAt(j) == 'W');
            }
        }

        int minFixCnt = 64;
        for (int i=0 ; i<n-7 ; i++) {
            for (int j=0 ; j<m-7 ; j++) {
                minFixCnt = Math.min(
                        minFixCnt,
                        Math.min(
                                getFixCnt(map, true, j, i),
                                getFixCnt(map, false, j, i)
                        )
                );
            }
        }
        System.out.println(minFixCnt);

        br.close();
        System.exit(0);
    }

    private static int getFixCnt(boolean[][] map, boolean type, int x, int y) {
        int fixCnt = 0;
        boolean status = type;
        for (int i=y ; i<y+8 ; i++) {
            for (int j=x ; j<x+8 ; j++) {
                if (map[i][j] != status) {
                    fixCnt++;
                }
                status = !status;
            }
            status = !status;
        }
        return fixCnt;
    }
}