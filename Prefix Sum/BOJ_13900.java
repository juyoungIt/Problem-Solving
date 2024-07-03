// BOJ - 13900
// Problem Sheet - https://www.acmicpc.net/problem/13900

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long totalSum = 0;
        int n = Integer.parseInt(br.readLine());
        long[] acc = new long[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1 ; i<=n ; i++) {
            int x = Integer.parseInt(st.nextToken());
            acc[i] = acc[i-1] + x;
            totalSum += acc[i-1] * x;
        }

        System.out.println(totalSum);

        br.close();
        System.exit(0);
    }
}