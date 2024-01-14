// BOJ - 6248
// Problem Sheet - https://www.acmicpc.net/problem/6248

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int m;
    private static int x;
    private static List<Status>[] al;
    private static int[] optCost;

    static class Status implements Comparable<Status> {
        private final int index;
        private final int optCost;

        public Status(int index, int optCost) {
            this.index = index;
            this.optCost = optCost;
        }

        public int getIndex() { return this.index; }
        public int getOptCost() { return this.optCost; }

        @Override
        public int compareTo(Status s) {
            return this.optCost - s.getOptCost();
        }
    }

    public static void main(String[] args) throws IOException {
        setup();
        dijkstra(x);
        System.out.println(Arrays.stream(optCost).max().getAsInt() * 2);
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        al = new List[n + 1];
        optCost = new int[n + 1];
        for(int i=1 ; i<=n ; i++) {
            al[i] = new LinkedList<>();
            optCost[i] = 100_000 * 100 + 1;
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
        optCost[src] = 0;
        while(!pq.isEmpty()) {
            Status curStatus = pq.poll();
            int curIndex = curStatus.getIndex();
            int curOptCost = curStatus.getOptCost();
            if(optCost[curIndex] < curOptCost) continue;
            for(Status nextStatus : al[curIndex]) {
                int nextIndex = nextStatus.getIndex();
                int nextCost = nextStatus.getOptCost();
                if(optCost[nextIndex] > curOptCost + nextCost) {
                    optCost[nextIndex] = curOptCost + nextCost;
                    pq.add(new Status(nextIndex, optCost[nextIndex]));
                }
            }
        }
    }
}