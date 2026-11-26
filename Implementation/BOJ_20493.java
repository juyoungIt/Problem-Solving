// BOJ - 20493
// Problem Sheet - https://acmicpc.net/problem/20493

import java.util.*;
import java.io.*;

public class Main {
    
    private static final int[] xi = { 1, 0, -1, 0 };
    private static final int[] yi = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] curLocation = new int[2];
        int dir = 0;
        int curTime = 0;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int ti = Integer.parseInt(st.nextToken());
            String si = st.nextToken();
            int diff = ti - curTime;
            curLocation[0] = curLocation[0] + xi[dir] * diff;
            curLocation[1] = curLocation[1] + yi[dir] * diff;
            if (si.equals("left")) {
                dir = (dir + 3) % 4;
            } else {
                dir = (dir + 1) % 4;
            }
            curTime = ti;
        }
        int diff = t - curTime;
        curLocation[0] = curLocation[0] + xi[dir] * diff;
        curLocation[1] = curLocation[1] + yi[dir] * diff;
        System.out.printf("%d %d\n", curLocation[0], curLocation[1]);
        br.close();
    }
}
