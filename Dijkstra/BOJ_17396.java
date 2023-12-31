// BOJ - 17396
// Problem Sheet - https://www.acmicpc.net/problem/17396

import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int m;
    private static int[] isVisible;
    private static List<Status>[] al;
    private static long[] minTime;

    static class Status implements Comparable<Status> {
        private final int index;
        private final long accTime;

        public Status(int index, long accTime) {
            this.index = index;
            this.accTime = accTime;
        }

        public int getIndex() { return this.index; }
        public long getAccTime() { return this.accTime; }


        @Override
        public int compareTo(Status s) {
            return Long.compare(this.accTime, s.getAccTime());
        }
    }

    public static void main(String[] args) throws IOException {
        setup();
        dijkstra(0);
        if(minTime[n-1] == 300_000L * 100_000L + 1) {
            System.out.println(-1);
        } else {
            System.out.println(minTime[n-1]);
        }
        System.exit(0);
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isVisible = new int[n];
        minTime = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            isVisible[i] = Integer.parseInt(st.nextToken());
            minTime[i] = 300_000L * 100_000L + 1;
        }

        al = new List[n];
        for(int i=0 ; i<n ; i++) {
            al[i] = new LinkedList<>();
        }
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            al[a].add(new Status(b, t));
            al[b].add(new Status(a, t));
        }

        br.close();
    }

    private static void dijkstra(int src) {
        PriorityQueue<Status> pq = new PriorityQueue<>();
        pq.add(new Status(src, 0));
        minTime[src] = 0;
        while(!pq.isEmpty()) {
            Status curStatus = pq.poll();
            int curIndex = curStatus.getIndex();
            long curAccTime = curStatus.getAccTime();
            if(minTime[curIndex] < curAccTime) continue;
            for(Status nextStatus : al[curIndex]) {
                int nextIndex = nextStatus.getIndex();
                long nextAccTime = nextStatus.getAccTime();
                if(isVisible[nextIndex] == 1 && nextIndex < n-1) continue;
                if(minTime[nextIndex] > curAccTime + nextAccTime) {
                    minTime[nextIndex] = minTime[curIndex] + nextAccTime;
                    pq.add(new Status(nextIndex, minTime[nextIndex]));
                }
            }
        }
    }
}