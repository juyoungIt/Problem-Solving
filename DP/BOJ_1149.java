// BOJ - 1149
// Problem Sheet - https://www.acmicpc.net/problem/1149

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine()); // 집의 수
        int[][] costs = new int[n+1][3]; // 각 집을 R,G,B로 색칠하는 데 들어가는 비용
        int[][] totalCosts = new int[n+1][3]; // i번째 집을 색칠하는 데 들어가는 비용의 최솟값 (for dp)
        for(int i=1 ; i<=n ; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<3 ; j++)
                costs[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=1 ; i<=n ; i++) {
            totalCosts[i][0] = Math.min(totalCosts[i-1][1], totalCosts[i-1][2]) + costs[i][0];
            totalCosts[i][1] = Math.min(totalCosts[i-1][0], totalCosts[i-1][2]) + costs[i][1];
            totalCosts[i][2] = Math.min(totalCosts[i-1][0], totalCosts[i-1][1]) + costs[i][2];
        }

        System.out.println(Math.min(Math.min(totalCosts[n][0], totalCosts[n][1]), totalCosts[n][2]));

        bf.close();
        System.exit(0);
    }
}