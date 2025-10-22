// BOJ - 11971
// Problem Sheet - https://www.acmicpc.net/problem/11971

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] limits = new int[100];
        int[] speeds = new int[100];

        int curPos = 0;
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());
            for (int j=curPos ; j<curPos+length ; j++) {
                limits[j] = limit;
            }
            curPos += length;
        }

        curPos = 0;
        for (int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            for (int j=curPos ; j<curPos+length ; j++) {
                speeds[j] = speed;
            }
            curPos += length;
        }

        int maxDiff = 0;
        for (int i=0 ; i<100 ; i++) {
            int diff = speeds[i] - limits[i];
            maxDiff = Math.max(maxDiff, diff);
        }
        System.out.println(maxDiff);
        br.close();
    }
}
