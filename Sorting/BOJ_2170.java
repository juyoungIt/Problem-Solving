// BOJ - 2170
// Problem Sheet - https://www.acmicpc.net/problem/2170

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] points = new int[n][2];
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(points, Comparator.comparingInt(e -> e[0]));

        long totalLineLength = 0;
        int start = points[0][0], end = points[0][1];
        for (int i=1 ; i<n ; i++) {
            if (isOverlap(start, end, points[i][0])) {
                end = Math.max(end, points[i][1]);
            } else {
                totalLineLength += (end - start);
                start = points[i][0];
                end = points[i][1];
            }
        }
        totalLineLength += end - start;
        System.out.println(totalLineLength);

        br.close();
    }

    private static boolean isOverlap(int prevX, int prevY, int nextX) {
        return prevX <= nextX && nextX <= prevY;
    }
}