// BOJ - 22865
// Problem Sheet - https://www.acmicpc.net/problem/22865

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int m;
    private static int a, b, c;
    private static List<Status>[] al;
    private static long[][] optDists;
    private static final long INFINITE = 500_000L * 10_000L + 1;

    static class Status implements Comparable<Status> {
        private final int dest;
        private final long optDist;

        public Status(int dest, long optDist) {
            this.dest = dest;
            this.optDist = optDist;
        }

        public int getDest() { return this.dest; }
        public long getOptDist() { return this.optDist; }

        @Override
        public int compareTo(Status s) {
            return Long.compare(this.optDist, s.getOptDist());
        }
    }

    public static void main(String[] args) throws IOException {
        setup();
        int result = 0;
        long minDist = 0;
        dijkstra(a, 0);
        dijkstra(b, 1);
        dijkstra(c, 2);
        for(int i=1 ; i<=n ; i++) {
            long curMinDist = getMinDist(optDists[0][i], optDists[1][i], optDists[2][i]);
            if(minDist < curMinDist) {
                minDist = curMinDist;
                result = i;
            }
        }
        System.out.println(result);
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        al = new List[n + 1];
        optDists = new long[3][n + 1];
        for(int i=1 ; i<=n ; i++) {
            al[i] = new LinkedList<>();
        }
        for(int i=0 ; i<3 ; i++) {
            Arrays.fill(optDists[i], INFINITE);
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            al[d].add(new Status(e, l));
            al[e].add(new Status(d, l));
        }

        br.close();
    }

    private static void dijkstra(int src, int idx) {
        PriorityQueue<Status> pq = new PriorityQueue<>();
        pq.add(new Status(src, 0));
        optDists[idx][src] = 0;
        while(!pq.isEmpty()) {
            Status curStatus = pq.poll();
            int curDest = curStatus.getDest();
            long curOptDist = curStatus.getOptDist();
            if(optDists[idx][curDest] < curOptDist) continue;
            for(Status nextStatus : al[curDest]) {
                int nextDest = nextStatus.getDest();
                long nextDist = nextStatus.getOptDist();
                if(optDists[idx][nextDest] > curOptDist + nextDist) {
                    optDists[idx][nextDest] = curOptDist + nextDist;
                    pq.add(new Status(nextDest, optDists[idx][nextDest]));
                }
            }
        }
    }

    private static long getMinDist(long distA, long distB, long distC) {
        return Math.min(distA, Math.min(distB, distC));
    }
}