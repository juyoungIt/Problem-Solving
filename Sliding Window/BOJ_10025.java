// BOJ - 11536
// Problem Sheet - https://www.acmicpc.net/problem/11536

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] cages = new int[1_000_000];
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            cages[x] = g;
        }

        int curIceCount = 0;
        for (int i=0 ; i<=k*2 ; i++) {
            if (i >= cages.length) break;
            curIceCount += cages[i];
        }

        int maxIceCount = curIceCount;
        for (int i=k+1 ; i<cages.length-k ; i++) {
            curIceCount -= cages[i - k - 1];
            curIceCount += cages[i + k];
            if (curIceCount > maxIceCount) {
                maxIceCount = curIceCount;
            }
        }

        System.out.println(maxIceCount);

        br.close();
        System.exit(0);
    }
}