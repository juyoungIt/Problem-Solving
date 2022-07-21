// BOJ - 1049
// Problem Sheet - https://www.acmicpc.net/problem/1049

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()); // 끊어진 기타줄의 수
        int m = Integer.parseInt(st.nextToken()); // 브랜드의 수
        int answer = 0;
        int minPackage = 0, minCost = 0; // 가장 저렴한 패키지, 낱개 가격
        int[] cost = new int[3]; // 각 3가지 case에 대한 최솟값 저장

        int[][] brandCost = new int[m][2];
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            brandCost[i][0] = Integer.parseInt(st.nextToken());
            brandCost[i][1] = Integer.parseInt(st.nextToken());
            if(i == 0) {
                minPackage = brandCost[i][0];
                minCost = brandCost[i][1];
                continue;
            }
            if(minPackage > brandCost[i][0])
                minPackage = brandCost[i][0];
            if(minCost > brandCost[i][1])
                minCost = brandCost[i][1];
        }

        cost[0] = (n%6 == 0) ? (n / 6) * minPackage : (n / 6 + 1) * minPackage;
        cost[1] = (n / 6) * minPackage + (n % 6) * minCost;
        cost[2] = n * minCost;

        answer = cost[0];
        for(int i=1 ; i<3 ; i++)
            if(answer > cost[i])
                answer = cost[i];

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}