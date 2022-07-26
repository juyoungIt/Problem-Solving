// BOJ - 11000
// Problem Sheet - https://www.acmicpc.net/problem/11000

import java.io.*;
import java.util.*;

class LectureTime implements Comparable<LectureTime>{
    private int start;
    private int end;

    public LectureTime(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    @Override
    public int compareTo(LectureTime lt) {
        if(this.end > lt.getEnd())
            return 1;
        else if(this.end < lt.getEnd())
            return -1;
        return 0;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int start, end;
        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<LectureTime>[] queues = new PriorityQueue[2]; // 강의실 정보를 저장할 우선순위 Queue
        queues[0] = new PriorityQueue<>();
        queues[1] = new PriorityQueue<>();
        int answer = 0;   // 강의실의 수
        int queueIdx = 0; // priority queue를 참조하는 인덱스
        int lastEnd = 0;  // 가장 최근에 강의가 종료된 시각

        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            queues[queueIdx].add(new LectureTime(start, end));
        }

        while(queues[0].size() > 0 || queues[1].size() > 0) {
            lastEnd = 0;
            answer++;
            while(queues[queueIdx].size() > 0) {
                if(lastEnd <= queues[queueIdx].peek().getStart()) {
                    lastEnd = queues[queueIdx].peek().getEnd();
                    queues[queueIdx].poll();
                }
                else
                    queues[(queueIdx == 0) ? 1 : 0].add(queues[queueIdx].poll());
            }
            queueIdx = (queueIdx == 0) ? 1 : 0;
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}