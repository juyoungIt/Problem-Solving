// BOJ - 18221
// Problem Sheet - https://www.acmicpc.net/problem/18221

import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        StringTokenizer st;
        Point seonggyu = new Point(0, 0), professor = new Point(0, 0);
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0 ; j<n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) seonggyu = new Point(i, j);
                if (map[i][j] == 5) professor = new Point(i, j);
            }
        }
        br.close();

        double dist = getDist(seonggyu, professor);
        if (dist < 5) {
            System.out.println(0);
            return;
        }
        int aroundCount = getAroundCount(map, seonggyu, professor);
        if (aroundCount >= 3) System.out.println(1);
        else System.out.println(0);
    }

    private static double getDist(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.r - p2.r, 2) + Math.pow(p1.c - p2.c, 2));
    }

    private static int getAroundCount(int[][] map, Point p1, Point p2) {
        int aroundCount = 0;
        for (int i=Math.min(p1.r, p2.r) ; i<=Math.max(p1.r, p2.r) ; i++) {
            for (int j=Math.min(p1.c, p2.c) ; j<=Math.max(p1.c, p2.c) ; j++) {
                if (map[i][j] == 1) aroundCount++;
            }
        }
        return aroundCount;
    }
}
