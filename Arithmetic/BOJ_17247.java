// BOJ - 17247
// Problem Sheet - https://www.acmicpc.net/problem/17247

import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Point[] points = new Point[2];
        int pointCnt = 0;
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<m ; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    points[pointCnt++] = new Point(j, i);
                }
            }
        }

        System.out.println(Math.abs(points[0].getX() - points[1].getX())
                + Math.abs(points[0].getY() - points[1].getY()));

        br.close();
        System.exit(0);
    }
}