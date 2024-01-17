// BOJ - 18223
// Problem Sheet - https://www.acmicpc.net/problem/18223

import java.util.*;
import java.io.*;

public class Main {

    private static int v;
    private static int e;
    private static int p;
    private static List<Status>[] al;
    private static int[] optDists;
    private static final int INFINITE = 10_000 * 10_000 + 1;
    private static final String SUCCESS_MESSAGE = "SAVE HIM";
    private static final String FAILED_MESSAGE = "GOOD BYE";

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
        dijkstra(1);
        int candidateA = optDists[v];
        int candidateB = optDists[p];
        dijkstra(p);
        candidateB += optDists[v];
        System.out.println(candidateA == candidateB ? SUCCESS_MESSAGE : FAILED_MESSAGE);
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        al = new List[v + 1];
        optDists = new int[v + 1];
        for(int i=1 ; i<=v ; i++) {
            al[i] = new LinkedList<>();
            optDists[i] = INFINITE;
        }

        for(int i=0 ; i<e ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            al[a].add(new Status(b, c));
            al[b].add(new Status(a, c));
        }

        br.close();
    }

    private static void dijkstra(int src) {
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