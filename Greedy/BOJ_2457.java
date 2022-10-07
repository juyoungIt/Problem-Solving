// BOJ - 2457
// Problem Sheet - https://www.acmicpc.net/problem/2457

import java.util.*;
import java.io.*;

class Date implements Comparable<Date> {
    private final int month; // 월
    private final int day;   // 일

    public Date(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public int getMonth() { return this.month; }
    public int getDay() { return this.day; }

    @Override
    public int compareTo(Date d) {
        if(this.month != d.getMonth()) return Integer.compare(this.month, d.getMonth());
        else return Integer.compare(this.day, d.getDay());
    }
}

class Flower implements Comparable<Flower> {
    private Date start; // 꽃이 피는 날짜
    private Date end;   // 꽃이 지는 날짜

    public Flower(int m1, int d1, int m2, int d2) {
        this.start = new Date(m1, d1);
        this.end = new Date(m2, d2);
    }

    public Date getStart() { return this.start; }
    public Date getEnd() { return this.end; }

    @Override
    public int compareTo(Flower f) {
        if(this.start.compareTo(f.getStart()) != 0) return this.start.compareTo(f.getStart());
        else return this.end.compareTo(f.getEnd());
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 꽃의 수
        Flower[] flowers = new Flower[n];

        Date sRange = new Date(3, 1);  // 범위 시작점
        Date eRange = new Date(12, 1); // 범위 종료점 (11월 30일까지는 꽃이 피어 있어야 하기 때문)
        boolean sRangeAvail = false, eRangeAvail = false; // 꽃들이 범위의 시작, 종료점을 모두 포함하는 가?
        ArrayList<Flower> selected = new ArrayList<>(); // 선택된 꽃들을 저장하는 queue

        StringTokenizer st;
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            flowers[i] = new Flower(sm, sd, em, ed);
            if(flowers[i].getStart().compareTo(sRange) <= 0) sRangeAvail = true;
            if(flowers[i].getEnd().compareTo(eRange) >= 0) eRangeAvail = true;
        }
        Arrays.sort(flowers); // 꽃을 정해진 기준에 따라 정렬

        // 정렬한 각각의 꽃에 대하여 다음을 반복함
        int curIdx = 0; // 현재 참조 중인 인덱스
        while(sRangeAvail && eRangeAvail && curIdx < n) {
            if(selected.size() == 0)
                selected.add(flowers[curIdx]);
            else if(selected.size() == 1) {
                if(flowers[curIdx].getStart().compareTo(sRange) <= 0) {
                    if(flowers[curIdx].getEnd().compareTo(selected.get(selected.size()-1).getEnd()) > 0) {
                        selected.remove(selected.size()-1);
                        selected.add(flowers[curIdx]);
                    }
                }
                else {
                    if(isConnectable(selected.get(selected.size()-1), flowers[curIdx])) {
                        if(flowers[curIdx].getEnd().compareTo(selected.get(selected.size()-1).getEnd()) > 0)
                            selected.add(flowers[curIdx]);
                    }
                }
            }
            else {
                if(isConnectable(selected.get(selected.size()-2), flowers[curIdx])) {
                    if(selected.get(selected.size()-1).getEnd().compareTo(flowers[curIdx].getEnd()) < 0) {
                        selected.remove(selected.size()-1);
                        selected.add(flowers[curIdx]);
                    }
                }
                else {
                    if(selected.get(selected.size()-1).getEnd().compareTo(flowers[curIdx].getStart()) >= 0) {
                        if(selected.get(selected.size()-1).getEnd().compareTo(flowers[curIdx].getEnd()) < 0)
                            selected.add(flowers[curIdx]);
                    }
                }
            }
            if(selected.get(selected.size()-1).getEnd().compareTo(eRange) >= 0) break;
            curIdx++;
        }

        if(selected.size() > 0 && selected.get(selected.size()-1).getEnd().compareTo(eRange) < 0)
            System.out.println(0);
        else
            System.out.println(selected.size());

        bf.close();
        System.exit(0);
    }

    static boolean isConnectable(Flower front, Flower rear) {
        return front.getEnd().compareTo(rear.getStart()) >= 0;
    }
}