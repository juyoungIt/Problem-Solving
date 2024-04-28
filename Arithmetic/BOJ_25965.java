// BOJ - 25965
// Problem Sheet - https://www.acmicpc.net/problem/25965

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i=0 ; i<N ; i++) {
            int M = Integer.parseInt(br.readLine());
            int[][] prices = new int[M][3];
            for (int j=0 ; j<M ; j++) {
                st = new StringTokenizer(br.readLine());
                prices[j][0] = Integer.parseInt(st.nextToken());
                prices[j][1] = Integer.parseInt(st.nextToken());
                prices[j][2] = Integer.parseInt(st.nextToken());
            }
            long totalPrice = 0;
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            for (int j=0 ; j<M ; j++) {
                long missionPrice = 0;
                missionPrice += (long) prices[j][0] * k;
                missionPrice -= (long) prices[j][1] * d;
                missionPrice += (long) prices[j][2] * a;
                totalPrice += Math.max(missionPrice, 0);
            }
            sb.append(totalPrice).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}