// BOJ - 10282
// Problem Sheet - https://www.acmicpc.net/problem/10282

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int c;
    private static final StringBuilder sb = new StringBuilder();
    private static int[] minTimes;
    private static List<Status>[] al;

    static class Status implements Comparable<Status> {
        private final int index;
        private final int minTime;

        public Status(int index, int minTime) {
            this.index = index;
            this.minTime = minTime;
        }

        public int getIndex() { return this.index; }
        public int getMinTime() { return this.minTime; }

        @Override
        public int compareTo(Status s) {
            return this.minTime - s.getMinTime();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i< t; i++) {
            setup(br);
            dijkstra(c);
            buildResult();
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static void setup(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        minTimes = new int[n + 1];
        al = new List[n + 1];
        for(int i=1 ; i<=n ; i++) {
            minTimes[i] = 100_000 * 1_000 + 1;
            al[i] = new LinkedList<>();
        }
        for(int i = 0; i< d; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            al[b].add(new Status(a, s));
        }
    }

    private static void dijkstra(int src) {
        PriorityQueue<Status> pq = new PriorityQueue<>();
        pq.add(new Status(src, 0));
        minTimes[src] = 0;
        while(!pq.isEmpty()) {
            Status curStatus = pq.poll();
            int curIndex = curStatus.getIndex();
            int curMinTime = curStatus.getMinTime();
            if(minTimes[curIndex] < curMinTime) continue;
            for(Status nextStatus : al[curIndex]) {
                int nextIndex = nextStatus.getIndex();
                int nextMinTime = nextStatus.getMinTime();
                if(minTimes[nextIndex] > curMinTime + nextMinTime) {
                    minTimes[nextIndex] = curMinTime + nextMinTime;
                    pq.add(new Status(nextIndex, minTimes[nextIndex]));
                }
            }
        }
    }

    private static void buildResult() {
        int infectedCnt = 0;
        int totalTime = 0;
        for(int i=1 ; i<=n ; i++) {
            if(minTimes[i] >= 0 && minTimes[i] < 100_000 * 1000 + 1) {
                infectedCnt++;
                totalTime = Math.max(totalTime, minTimes[i]);
            }
        }
        sb.append(infectedCnt)
                .append(" ")
                .append(totalTime)
                .append("\n");
    }
}