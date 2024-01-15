// BOJ - 20168
// Problem Sheet - https://www.acmicpc.net/problem/20168

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int m;
    private static int a;
    private static int b;
    private static int c;
    private static List<Status>[] al;
    private static int[] optCosts;
    private static final int INFINITE = 45 * 1_000 + 1;

    static class Status implements Comparable<Status> {
        private final int dest;
        private final int optCost;

        public Status(int dest, int optCost) {
            this.dest = dest;
            this.optCost = optCost;
        }

        public int getDest() { return this.dest; }
        public int getOptCost() { return this.optCost; }

        @Override
        public int compareTo(Status s) {
            return this.optCost - s.getOptCost();
        }
    }

    public static void main(String[] args) throws IOException {
        setup();
        int start = 1;
        int end = 1_000;
        int optUnitCost = -1;
        while(start <= end) {
            int mid = (start + end) / 2;
            dijkstra(a, mid);
            if(optCosts[b] == INFINITE) {
                start++;
            } else {
                optUnitCost = mid;
                end--;
            }
        }
        System.out.println(optUnitCost);
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        al = new List[n + 1];
        optCosts = new int[n + 1];
        for(int i=1 ; i<=n ; i++) {
            al[i] = new LinkedList<>();
            optCosts[i] = INFINITE;
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int ai = Integer.parseInt(st.nextToken());
            int bi = Integer.parseInt(st.nextToken());
            int ci = Integer.parseInt(st.nextToken());
            al[ai].add(new Status(bi, ci));
            al[bi].add(new Status(ai, ci));
        }

        br.close();
    }

    private static void dijkstra(int src, int unitLimit) {
        for(int i=1 ; i<=n ; i++) {
            optCosts[i] = INFINITE;
        }
        PriorityQueue<Status> pq = new PriorityQueue<>();
        pq.add(new Status(src, 0));
        optCosts[src] = 0;
        while(!pq.isEmpty()) {
            Status curStatus = pq.poll();
            int curDest = curStatus.getDest();
            int curOptCost = curStatus.getOptCost();
            if(optCosts[curDest] < curOptCost) continue;
            for(Status nextStatus : al[curDest]) {
                int nextDest = nextStatus.getDest();
                int nextCost = nextStatus.getOptCost();
                if(optCosts[nextDest] > curOptCost + nextCost
                        && nextCost <= unitLimit
                        && curOptCost + nextCost <= c) {
                    optCosts[nextDest] = curOptCost + nextCost;
                    pq.add(new Status(nextDest, optCosts[nextDest]));
                }
            }
        }
    }
}