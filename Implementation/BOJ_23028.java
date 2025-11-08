// BOJ - 23028
// Problem Sheet - https://www.acmicpc.net/problem/23028

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] classes = new int[10][2];
        for (int i=0 ; i<10 ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            classes[i][0] = x;
            classes[i][1] = y;
        }
        for (int i=0 ; i<8-n ; i++) {
            a += 3 * classes[i][0];
            b += 3 * Math.min(6, classes[i][0] + classes[i][1]);
        }
        if (a >= 66 & b >= 130) System.out.println("Nice");
        else System.out.println("Nae ga wae");
        br.close();
    }
}