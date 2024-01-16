// BOJ - 5944
// Problem Sheet - https://www.acmicpc.net/problem/5944

import java.util.*;
import java.io.*;

public class Main {

    private static int c;
    private static int p;
    private static int pb;
    private static int pa1;
    private static int pa2;
    private static List<Status>[] al;
    private static int[] optDists;

    static class Status implements Comparable<Status> {
        private final int dest;
        private final int optDist;

        public Status(int dest, int optDist) {
            this.dest = dest;
            this.optDist = optDist;
        }

        public int getDest() { return this.dest; }
        public int getOptDist() { return this.optDist; }

        @Override
        public int compareTo(Status s) {
            return this.optDist - s.getOptDist();
        }
    }

    public static void main(String[] args) throws IOException {
        setup();
        dijkstra(pb);
        int candidateA = optDists[pa1];
        int candidateB = optDists[pa2];
        dijkstra(pa1);
        candidateA += optDists[pa2];
        candidateB += optDists[pa2];
        System.out.println(Math.min(candidateA, candidateB));
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        pb = Integer.parseInt(st.nextToken());
        pa1 = Integer.parseInt(st.nextToken());
        pa2 = Integer.parseInt(st.nextToken());

        al = new List[p + 1];
        optDists = new int[p + 1];
        for(int i=1 ; i<=p ; i++) {
            al[i] = new LinkedList<>();
            optDists[i] = Integer.MAX_VALUE;
        }
        for(int i=0 ; i<c ; i++) {
            st = new StringTokenizer(br.readLine());
            int p1i = Integer.parseInt(st.nextToken());
            int p2i = Integer.parseInt(st.nextToken());
            int di = Integer.parseInt(st.nextToken());
            al[p1i].add(new Status(p2i, di));
            al[p2i].add(new Status(p1i, di));
        }

        br.close();
    }

    private static void dijkstra(int src) {
        Arrays.fill(optDists, Integer.MAX_VALUE);
        PriorityQueue<Status> pq = new PriorityQueue<>();
        pq.add(new Status(src, 0));
        optDists[src] = 0;
        while(!pq.isEmpty()) {
            Status curStatus = pq.poll();
            int curDest = curStatus.getDest();
            int curOptDist = curStatus.getOptDist();
            if(optDists[curDest] < curOptDist) continue;
            for(Status nextStatus : al[curDest]) {
                int nextDest = nextStatus.getDest();
                int nextDist = nextStatus.getOptDist();
                if(optDists[nextDest] > curOptDist + nextDist) {
                    optDists[nextDest] = curOptDist + nextDist;
                    pq.add(new Status(nextDest, optDists[nextDest]));
                }
            }
        }
    }
}