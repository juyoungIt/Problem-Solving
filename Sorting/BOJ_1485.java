// BOJ - 1485
// Problem Sheet - https://www.acmicpc.net/problem/1485

import java.util.*;
import java.io.*;

public class Main {

    static class Point implements Comparable<Point> {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }

        @Override
        public int compareTo(Point p) {
            if (this.y == p.getY()) {
                return this.x - p.getX();
            }
            return this.y - p.getY();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            Point[] points = new Point[4];
            for (int j=0 ; j<4 ; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[j] = new Point(x, y);
            }
            Arrays.sort(points);
            sb.append(isSquare(points) ? 1 : 0).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static boolean isSquare(Point[] points) {
        return isAllSideLengthSame(points) && isSameDiagonalLength(points);
    }

    private static boolean isAllSideLengthSame(Point[] points) {
        double sideA = getDifference(points[0], points[1]);
        double sideB = getDifference(points[0], points[2]);
        double sideC = getDifference(points[1], points[3]);
        double sideD = getDifference(points[2], points[3]);
        return sideA == sideB && sideB == sideC && sideC == sideD;
    }

    private static boolean isSameDiagonalLength(Point[] points) {
        double diagonalA = getDifference(points[0], points[3]);
        double diagonalB = getDifference(points[1], points[2]);
        return diagonalA == diagonalB;
    }

    private static double getDifference(Point pointA, Point pointB) {
        return Math.sqrt(
                Math.pow(pointA.getX() - pointB.getX(), 2)
                        + Math.pow(pointA.getY() - pointB.getY(), 2)
        );
    }
}