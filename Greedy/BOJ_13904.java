// BOJ - 13904
// Problem Sheet - https://www.acmicpc.net/problem/13904

import java.util.*;
import java.io.*;

class Assignment implements Comparable<Assignment> {
    private final int due; // 남은 기간
    private final int point; // 받을 수 있는 점수

    public Assignment(int due, int point) {
        this.due = due;
        this.point = point;
    }

    public int getDue() { return this.due; }
    public int getPoint() { return this.point; }

    @Override
    public int compareTo(Assignment a) {
        return Integer.compare(this.point, a.getPoint()) * -1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Assignment> pQueue = new PriorityQueue<>(); // 과제점수 순으로 내림차순 정렬
        boolean[] assinged = new boolean[1000+1]; // 일자별 과제의 배치여부를 저장
        int answer = 0; // 득점할 수 있는 최대값

        int n = Integer.parseInt(bf.readLine()); // 과제의 수
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            int due = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());
            pQueue.add(new Assignment(due, point));
        }

        // queue가 완전히 비워질 때까지 다음을 반복함
        while(!pQueue.isEmpty()) {
            Assignment tmp = pQueue.poll();
            for(int i=tmp.getDue() ; i>=1 ; i--) {
                if(!assinged[i]) {
                    assinged[i] = true;
                    answer += tmp.getPoint();
                    break;
                }
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}