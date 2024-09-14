// BOJ - 2246
// Problem Sheet - https://www.acmicpc.net/problem/2246

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] candidates = new int[n][2];
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            candidates[i][0] = d;
            candidates[i][1] = c;
        }
        Arrays.sort(candidates, (c1, c2) -> {
            if (c1[0] == c2[0]) {
                return c1[1] - c2[1];
            }
            return c1[0] - c2[0];
        });

        int candidateCount = 0;
        int prevPrice = 10_001;
        for (int[] candidate : candidates) {
            if (candidate[1] < prevPrice) {
                prevPrice = candidate[1];
                candidateCount++;
            }
        }

        System.out.println(candidateCount);

        br.close();
        System.exit(0);
    }
}