// BOJ - 11000
// Problem Sheet - https://www.acmicpc.net/problem/11000

import java.io.*;
import java.util.*;

class LectureTime implements Comparable<LectureTime> {
    private final int start;
    private final int end;

    public LectureTime(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() { return this.start; }

    public int getEnd() { return this.end; }

    @Override
    public int compareTo(LectureTime lt) {
        if(this.start > lt.getStart())
            return 1;
        else if(this.start < lt.getStart())
            return -1;
        return 0;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<LectureTime> lQueue = new PriorityQueue<>(); // 개설된 강의를 종료시간 기준 오름차순 정렬
        PriorityQueue<Integer> lRoom = new PriorityQueue<>();  // 각 강의실 별 마지막 강의 정보를 저장

        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            lQueue.add(new LectureTime(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        lRoom.add(lQueue.poll().getEnd());
        while(lQueue.size() > 0) {
            if(lRoom.peek() <= lQueue.peek().getStart()) {
                lRoom.poll();
                lRoom.add(lQueue.poll().getEnd());
            }
            else
                lRoom.add(lQueue.poll().getEnd());
        }

        System.out.println(lRoom.size());

        bf.close();
        System.exit(0);
    }
}
