// BOJ - 15235
// Problem Sheet - https://www.acmicpc.net/problem/15235

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine()); // 참가자의 수
        int[] needs = new int[n]; // 각각 필요한  피자의 수
        int totalPieces = 0; // 필요한 총 조각의 수
        int[] totalTimes = new int[n]; // 각각의 사람이 원하는 양의 피자를 받는 데 필요한 시간
        int curTime = 0;
        int curIndex = 0;

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++) {
            int need = Integer.parseInt(st.nextToken());
            needs[i] = need;
            totalPieces += need;
        }

        while(totalPieces > 0) {
            curTime++;
            curIndex %= n; // 인덱스 업데이트
            if(needs[curIndex] > 0) {
                totalTimes[curIndex] = curTime;
                needs[curIndex]--;
                totalPieces--;
            } else {
                curTime--;
            }
            curIndex++;
        }

        // 종합된 결과를 출력
        for(int time : totalTimes) {
            System.out.print(time + " ");
        }
        System.out.println();

        bf.close();
        System.exit(0);
    }
}