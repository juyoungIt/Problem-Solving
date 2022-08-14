// BOJ - 14469
// Problem Sheet - https://www.acmicpc.net/problem/14469

import java.io.*;
import java.util.*;

class CowInfo implements Comparable<CowInfo> {
    private int arrivedTime; // 도착시간
    private int enterTime;  // 입장시간

    public CowInfo(int at, int et) {
        this.arrivedTime = at;
        this.enterTime = et;
    }

    public int getArrivedTime() { return this.arrivedTime; }
    public int getEnterTime() { return this.enterTime; }

    @Override
    public int compareTo(CowInfo c) {
        if(this.arrivedTime > c.getArrivedTime())
            return 1;
        else if(this.arrivedTime < c.getArrivedTime())
            return -1;
        else
            return 0;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 소의 수
        PriorityQueue<CowInfo> cowQueue = new PriorityQueue<>(); // 소의 정보를 저장
        StringTokenizer st;
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            cowQueue.add(new CowInfo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int finishTime = 0; // 종료시각

        while(cowQueue.size() > 0) {
            if(cowQueue.peek().getArrivedTime() >= finishTime)
                finishTime = cowQueue.peek().getArrivedTime() + cowQueue.peek().getEnterTime();
            else
                finishTime = finishTime + cowQueue.peek().getEnterTime();
            cowQueue.poll();
        }

        System.out.println(finishTime);

        bf.close();
        System.exit(0);
    }
}