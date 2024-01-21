// BOJ - 20007
// Problem Sheet - https://www.acmicpc.net/problem/20007

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int m;
    private static int x;
    private static int y;
    private static List<Status>[] al;
    private static Integer[] optDists;
    private static final int INFINITE = 100_000 * 10_000 + 1;

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
        dijkstra(y);
        Arrays.sort(optDists);
        int result = 1;
        if(optDists[n-1] * 2 > x) {
            result = -1;
        } else {
            int limit = x;
            for(int optDist : optDists) {
                if(optDist * 2 <= limit) {
                    limit -= optDist * 2;
                } else {
                    result++;
                    limit = x - optDist * 2;
                }
            }
        }
        System.out.println(result);
        System.exit(0);
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        al = new List[n];
        optDists = new Integer[n];
        for(int i=0 ; i<n ; i++) {
            al[i] = new LinkedList<>();
            optDists[i] = INFINITE;
        }
        for(int i=0 ; i<m ; i++) {
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