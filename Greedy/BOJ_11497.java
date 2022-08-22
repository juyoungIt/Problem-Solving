// BOJ - 11497
// Problem Sheet - https://www.acmicpc.net/problem/11497

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tcSize = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수
        int[] answers = new int[tcSize]; // 정답을 저장하는 배열
        StringTokenizer st;
        for(int i=0 ; i<tcSize ; i++) {
            int n = Integer.parseInt(bf.readLine()); // 통나무의 수
            int[] logs = new int[n]; // 통나무의 높이를 저장 (최적 솔루션)
            PriorityQueue<Integer> pQueue = new PriorityQueue<>(n);
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<n ; j++)
                pQueue.add(Integer.parseInt(st.nextToken()));
            int answer = 0;

            // 최적의 솔루션을 얻을 수 있는 형태로 배열을 구성
            for(int j=0 ; !pQueue.isEmpty() ; j++) {
                logs[j] = pQueue.poll();
                if(pQueue.isEmpty())
                    break;
                logs[n-1-j] = pQueue.poll();
            }

            // 인접한 통나무들 간의 차 계산 및 최댓값을 구함
            for(int j=0 ; j<n ; j++) {
                int tmp = (j != n-1) ? Math.abs(logs[j]-logs[j+1]) : Math.abs(logs[0]-logs[n-1]);
                if(answer < tmp)
                    answer = tmp;
            }
            answers[i] = answer;
        }

        // 각 테스트 케이스에 대한 솔루션을 출력
        for(int answer : answers)
            System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}