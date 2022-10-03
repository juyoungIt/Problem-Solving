// BOJ - 2530
// Problem Sheet - https://www.acmicpc.net/problem/2530

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] startTime = new int[3]; // 시작하는 시간
        for(int i=0 ; i<3 ; i++)
            startTime[i] = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(bf.readLine()); // 소비한 시간

        // 소요시간을 반영하여 시간을 계산함
        startTime[0] += time / 3600;
        time %= 3600;
        startTime[1] += time / 60;
        time %= 60;
        startTime[2] += time;

        // 범위에서 벗어난 수에 대한 처리를 수행
        if(startTime[2] >= 60) {
            startTime[2] -= 60;
            startTime[1]++;
        }
        if(startTime[1] >= 60) {
            startTime[1] -= 60;
            startTime[0]++;
        }
        if(startTime[0] >= 24)
            startTime[0] %= 24;

        // 결과값을 출력함
        for(int t : startTime)
            System.out.print(t + " ");
        System.out.println();

       bf.close();
       System.exit(0);
    }
}