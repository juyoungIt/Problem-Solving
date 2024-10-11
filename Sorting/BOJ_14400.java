// BOJ - 14400
// Problem Sheet - https://www.acmicpc.net/problem/14400

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(x);
        Arrays.sort(y);

        int optX = x[n/2];
        int optY = y[n/2];

        long answer = 0;
        for (int i=0 ; i<n ; i++) {
            answer += getDist(optX, optY, x[i], y[i]);
        }
        System.out.println(answer);

        br.close();
    }

    private static long getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}