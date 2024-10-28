// BOJ - 10025
// Problem Sheet - https://www.acmicpc.net/problem/10025

import java.util.*;
import java.io.*;

public class Main {

    private static final int RANGE = 1_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] buckets = new int[RANGE];
        int WINDOW_SIZE = 2 * K + 1;
        int totalIce = 0;
        for (int i=0 ; i<N ; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            buckets[x] = g;
            if (x < WINDOW_SIZE) {
                totalIce += g;
            }
        }

        int maxIce = 0;
        for (int i = 0; i<=Math.max(0, RANGE - WINDOW_SIZE) ; i++) {
            maxIce = Math.max(maxIce, totalIce);
            if (i + WINDOW_SIZE >= RANGE) break;
            totalIce -= buckets[i];
            totalIce += buckets[i + WINDOW_SIZE];
        }
        System.out.println(maxIce);

        br.close();
    }
}