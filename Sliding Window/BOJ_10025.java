// BOJ - 10025
// Problem Sheet - https://www.acmicpc.net/problem/10025

import java.util.*;
import java.io.*;

public class Main {

    private static final int CAGE_SIZE = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) * 2 + 1;
        int[] cage = new int[CAGE_SIZE + 1];
        for (int i=0 ; i<N ; i++) {
            st = new StringTokenizer(br.readLine());
            int gi = Integer.parseInt(st.nextToken());
            int xi = Integer.parseInt(st.nextToken());
            cage[xi] = gi;
        }

        int totalIce = 0;
        int maxTotalIce = 0;
        for (int i=0 ; i<=CAGE_SIZE ; i++) {
            if (i - K >= 0) {
                totalIce -= cage[i - K];
            }
            totalIce += cage[i];
            maxTotalIce = Math.max(totalIce, maxTotalIce);
        }
        System.out.println(maxTotalIce);

        br.close();
    }
}