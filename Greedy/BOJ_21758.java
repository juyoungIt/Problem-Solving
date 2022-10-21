// BOJ - 21758
// Problem Sheet - https://www.acmicpc.net/problem/21758

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 장소의 수
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] honeys = new int[n]; // 각 장소에서 얻을 수 있는 꿀의 양
        int[] aSum = new int[n];    // 각 꿀의 양에 대한 누적합
        for(int i=0 ; i<n ; i++) {
            honeys[i] = Integer.parseInt(st.nextToken());
            if(i == 0) aSum[i] = honeys[i];
            else aSum[i] = aSum[i-1] + honeys[i];
        }
        int hLeft = 0, hCenter = 0, hRight = 0;

        // 1. 꿀통이 두 벌의 오른쪽에 있는 경우
        for(int i=1 ; i<n-1 ; i++) {
            int sum = (aSum[n-1] - aSum[0] - honeys[i]) + (aSum[n-1] - aSum[i]);
            if(hLeft < sum) hLeft = sum;
        }

        // 2. 꿀통이 두 벌의 사이에 있는 경우
        for(int i=1 ; i<n-1 ; i++) {
            int sum = (aSum[n-2] - aSum[0]) + honeys[i];
            if(hCenter < sum) hCenter = sum;
        }

        // 3. 꿀통이 두 벌의 왼쪽에 있는 경우
        for(int i=1 ; i<n-1 ; i++) {
            int sum = (aSum[n-2] - honeys[i]) + aSum[i-1];
            if(hRight < sum) hRight = sum;
        }

        System.out.println(Math.max(hLeft, Math.max(hCenter, hRight)));

        bf.close();
        System.exit(0);
    }
}