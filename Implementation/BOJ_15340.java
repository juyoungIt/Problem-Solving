// BOJ - 15340
// Problem Sheet - https://www.acmicpc.net/problem/15340

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[][] prices = { { 30, 40 }, { 35, 30 }, { 40, 20 } };
        while (true) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (c == 0 && d == 0) break;
            int minPrice = Integer.MAX_VALUE;
            for (int[] price : prices) {
                int sum = c * price[0] + d * price[1];
                minPrice = Math.min(minPrice, sum);
            }
            sb.append(minPrice).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}