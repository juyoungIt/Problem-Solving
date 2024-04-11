// BOJ - 16283
// Problem Sheet - https://www.acmicpc.net/problem/16283

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int solutionCount = 0;
        int sheepCount = 0, goatCount = 0;
        for (int i=1 ; i<n ; i++) {
            if (a * i + b * (n - i) == w) {
                solutionCount++;
                sheepCount = i;
                goatCount = n - i;
            }
        }

        if (solutionCount == 1) {
            System.out.printf("%d %d\n", sheepCount, goatCount);
        } else {
            System.out.println(-1);
        }

        br.close();
        System.exit(0);
    }
}