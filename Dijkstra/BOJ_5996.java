// BOJ - 5996
// Problem Sheet - https://www.acmicpc.net/problem/5996

import java.util.*;
import java.io.*;

public class Main {

    private static int ts;
    private static int te;
    private static List<Status>[] al;
    private static int[] shortestLength;
    private static final int INFINITE = 6_200 * 1_000 + 1;

    static class Status implements Comparable<Status> {
        private final int dest;
        private final int shortestLength;

        public Status(int dest, int shortestLength) {
            this.dest = dest;
            this.shortestLength = shortestLength;
        }

        public int getDest() { return this.dest; }
        public int getShortestLength() { return this.shortestLength; }

        @Override
        public int compareTo(Status s) {
            return this.shortestLength - s.getShortestLength();
        }
    }

    public static void main(String[] args) throws IOException {
        setup();
        dijkstra(ts);
        System.out.println(shortestLength[te] == INFINITE ? -1 : shortestLength[te]);
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        ts = Integer.parseInt(st.nextToken());
        te = Integer.parseInt(st.nextToken());

        al = new List[t + 1];
        shortestLength = new int[t + 1];
        for(int i = 1; i<= t; i++) {
            al[i] = new LinkedList<>();
            shortestLength[i] = INFINITE;
        }

        for(int i = 0; i< c; i++) {
            st = new StringTokenizer(br.readLine());
            int r1i = Integer.parseInt(st.nextToken());
            int r2i = Integer.parseInt(st.nextToken());
            int ci = Integer.parseInt(st.nextToken());
            al[r1i].add(new Status(r2i, ci));
            al[r2i].add(new Status(r1i, ci));
        }

        br.close();
    }

    private static void dijkstra(int src) {
        PriorityQueue<Status> pq = new PriorityQueue<>();
        pq.add(new Status(src, 0));
        shortestLength[src] = 0;
        while(!pq.isEmpty()) {
            Status curStatus = pq.poll();
            int curDest = curStatus.getDest();
            int curShortestLength = curStatus.getShortestLength();
            if(shortestLength[curDest] < curShortestLength) continue;
            for(Status nextStatus : al[curDest]) {
                int nextDest = nextStatus.getDest();
                int nextLength = nextStatus.getShortestLength();
                if(shortestLength[nextDest] > curShortestLength + nextLength) {
                    shortestLength[nextDest] = curShortestLength + nextLength;
                    pq.add(new Status(nextDest, shortestLength[nextDest]));
                }
            }
        }
    }
}