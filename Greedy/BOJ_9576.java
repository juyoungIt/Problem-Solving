// BOJ - 9576
// Problem Sheet - https://www.acmicpc.net/problem/9576

import java.util.*;
import java.io.*;

class Request implements Comparable<Request> {
    private final int start;
    private final int end;

    public Request(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() { return this.start; }
    public int getEnd() { return this.end; }

    @Override
    public int compareTo(Request r) {
        if(this.end == r.getEnd())
            return Integer.compare(this.start, r.getStart());
        else
            return Integer.compare(this.end, r.getEnd());
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tcSize = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수
        int[] answers = new int[tcSize]; // 각 테스트 케이스의 정답을 저장

        // 각 테스트 케이스에 대하여 다음을 반복함
        StringTokenizer st;
        for(int i=0 ; i<tcSize ; i++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken()); // 책의 수
            int m = Integer.parseInt(st.nextToken()); // 책을 원하는 학생의 수
            boolean[] books = new boolean[n+1]; // 각 책들의 할당 여부
            PriorityQueue<Request> pQueue = new PriorityQueue<>();

            // 요청정보를 입력받아 범위 마지막 수 크기 기준 오름차순 정렬
            for(int j=0 ; j<m ; j++) {
                st = new StringTokenizer(bf.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                pQueue.add(new Request(start, end)); // b 기준 오름차순 정렬, a 기준 내림차순 정렬
            }

            // 정렬한 순서를 기반으로 배치를 수행함
            while(!pQueue.isEmpty()) {
                Request r = pQueue.poll();
                for(int j=r.getStart() ; j<=r.getEnd() ; j++) {
                    if(!books[j]) {
                        books[j] = true;
                        answers[i]++;
                        break;
                    }
                }
            }
        }

        // 산출된 결과를 출력함
        for(int answer : answers)
            System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}