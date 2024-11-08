// BOJ - 25426
// Problem Sheet - https://www.acmicpc.net/problem/25426

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arguments = new int[N][2];
        for (int i=0 ; i<N ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) break;
            arguments[i][0] = a;
            arguments[i][1] = b;
        }
        Arrays.sort(arguments, Comparator.comparingInt(a -> a[0]));

        long maxSum = 0;
        for (int i=0 ; i<N ; i++) {
            maxSum += (long) arguments[i][0] * (i + 1) + arguments[i][1];
        }
        System.out.println(maxSum);
        br.close();
    }
}