// BOJ - 20040
// Problem Sheet - https://www.acmicpc.net/problem/20040

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        boolean isCycle = false;
        int currentTurn = 0;

        int numberOfPoints = Integer.parseInt(st.nextToken());
        int[] points = new int[numberOfPoints];
        for(int i=0 ; i<numberOfPoints ; i++) {
            points[i] = i;
        }
        int numberOfTurns = Integer.parseInt(st.nextToken());
        for(int i=0 ; i<numberOfTurns ; i++) {
            currentTurn++;
            st = new StringTokenizer(bf.readLine());
            int pointA = Integer.parseInt(st.nextToken());
            int pointB = Integer.parseInt(st.nextToken());

            if(isSameSet(points, pointA, pointB)) {
                isCycle = true;
                break;
            } else {
                connect(points, pointA, pointB);
            }
        }

        if(isCycle) {
            System.out.println(currentTurn);
        } else {
            System.out.println(0);
        }

        bf.close();
        System.exit(0);
    }

    private static int getRootPoint(int[] points, int point) {
        if(points[point] == point) {
            return point;
        }
        return points[point] = getRootPoint(points, points[point]);
    }

    private static void connect(int[] points, int pointA, int pointB) {
        int rootOfPointA = getRootPoint(points, pointA);
        int rootOfPointB = getRootPoint(points, pointB);

        if(rootOfPointA < rootOfPointB) {
            points[rootOfPointB] = rootOfPointA;
        } else {
            points[rootOfPointA] = rootOfPointB;
        }
    }

    private static boolean isSameSet(int[] points, int pointA, int pointB) {
        return getRootPoint(points, pointA) == getRootPoint(points, pointB);
    }
}