// BOJ - 1374
// Problem Sheet - https://www.acmicpc.net/problem/1374

import java.util.*;
import java.io.*;

class Lecture {
    private final int num; // 강의번호
    private final int start; // 강의시작시각
    private final int end; // 강의종료시각

    public Lecture(int num, int start, int end) {
        this.num = num;
        this.start = start;
        this.end = end;
    }

    public int getNum() { return this.num; }
    public int getStart() { return this.start; }
    public int getEnd() { return this.end; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정렬에 사용하기 위한 Comparator를 정의
        Comparator<Lecture> startBase = new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                return Integer.compare(o1.getStart(), o2.getStart());
            }
        };

        Comparator<Lecture> endBase = new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                return Integer.compare(o1.getEnd(), o2.getEnd());
            }
        };

        int n = Integer.parseInt(bf.readLine()); // 강의실의 수
        Lecture[] lectures = new Lecture[n]; // 강의정보 저장
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(num, start, end);
        }
        Arrays.sort(lectures, startBase); // 시작시간 기준으로 강의를 정렬

        // 정렬된 각각의 강의에 대해서 다음을 반복함
        PriorityQueue<Lecture> queue = new PriorityQueue<>(endBase); // 종료시간이 작은 것을 우선순위로 정렬함
        for(int i=0 ; i<n ; i++) {
            if(queue.isEmpty()) queue.add(lectures[i]);
            else {
                if(queue.peek().getEnd() <= lectures[i].getStart()) {
                    queue.poll();
                    queue.add(lectures[i]);
                    continue;
                }
                queue.add(lectures[i]);
            }
        }

        System.out.println(queue.size());

        bf.close();
        System.exit(0);
    }
}