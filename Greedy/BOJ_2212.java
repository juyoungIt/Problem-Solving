// BOJ - 2212
// Problem Sheet - https://www.acmicpc.net/problem/2212

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 센서의 갯수
        int k = Integer.parseInt(bf.readLine()); // 집중국의 갯수
        int[] sensors = new int[n];
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(); // 각 센서간의 거리 저장
        int answer = 0; // 수신 가능 영역 길이의 합의 최솟값

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++)
            sensors[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(sensors); // 좌표 오름차순으로 정렬함

        // 각 센서별 거리의 차를 구함
        for(int i=0 ; i<n-1 ; i++)
            pQueue.add(sensors[i+1] - sensors[i]);

        for(int i=0 ; i<n-k ; i++)
            answer += pQueue.poll();

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}