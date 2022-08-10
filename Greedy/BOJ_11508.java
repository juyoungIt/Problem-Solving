// BOJ - 11508
// Problem Sheet - https://www.acmicpc.net/problem/11508

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 유제품의 수
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 유제품의 가격을 내림차순으로 저장
        for(int i=0 ; i<n ; i++)
            pq.add(Integer.parseInt(bf.readLine()));
        int count = 1;
        int answer = 0;

        // pq의 모든 원소를 소진할 때까지 다음을 반복
        while(pq.size() > 0) {
            if(count == 3) {
                count = 1;
                pq.poll();
                continue;
            }
            answer += pq.poll();
            count++;
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}