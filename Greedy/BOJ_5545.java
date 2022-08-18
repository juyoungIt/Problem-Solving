// BOJ - 5545
// Problem Sheet - https://www.acmicpc.net/problem/5545

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine()); // 토핑 종류 수
        st = new StringTokenizer(bf.readLine());
        int dPrice = Integer.parseInt(st.nextToken()); // 도우 가격
        int tPrice = Integer.parseInt(st.nextToken()); // 토핑 가격
        int dKcal = Integer.parseInt(bf.readLine()); // 도우 열량
        PriorityQueue<Integer> tKcalQueue = new PriorityQueue<>(Collections.reverseOrder()); // 토핑의 열량을 저장 (내림차순)
        for(int i=0 ; i<n ; i++)
            tKcalQueue.add(Integer.parseInt(bf.readLine()));

        int tmpPrice = dPrice, tmpKcal = dKcal; // 중간연산을 위한 임시저장값
        double answer = (double)tmpKcal / tmpPrice; // 토핑을 사용하지 않은 경우
        while(!tKcalQueue.isEmpty()) {
            if(answer < (((double)tmpKcal + tKcalQueue.peek()) / (tmpPrice + tPrice))) {
                tmpPrice += tPrice;
                tmpKcal += tKcalQueue.poll();
                answer = (double)tmpKcal / tmpPrice;
            }
            else
                break;
        }

        System.out.println((int)answer);

        bf.close();
        System.exit(0);
    }
}