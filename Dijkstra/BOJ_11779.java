// BOJ - 11779
// Problem Sheet - https://www.acmicpc.net/problem/11779

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int m;
    private static int a;
    private static int b;
    private static List<Info>[] al;
    private static List<Integer>[] optPaths;
    private static long[] minCost;

    static class Info {
        private final int dest;
        private final int cost;

        public Info(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        public int getDest() { return this.dest; }
        public int getCost() { return this.cost; }
    }

    static class Status implements Comparable<Status> {
        private final int index;
        private final long minCost;
        private final List<Integer> optPath;

        public Status(int index, long minCost, List<Integer> optPath) {
            this.index = index;
            this.minCost = minCost;
            this.optPath = optPath;
        }

        public int getIndex() { return this.index; }
        public long getMinCost() { return this.minCost; }
        public List<Integer> getOptPath() { return this.optPath; }

        @Override
        public int compareTo(Status s) {
            return Long.compare(this.minCost, s.getMinCost());
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        setup();
        dijkstra(a);
        sb.append(minCost[b])
                .append("\n")
                .append(optPaths[b].size())
                .append("\n")
                .append(getPathString(optPaths[b]))
                .append("\n");
        System.out.println(sb);
        System.exit(0);
    }

    public static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        al = new List[n + 1];
        minCost = new long[n + 1];
        optPaths = new List[n + 1];
        for(int i=1 ; i<=n ; i++) {
            al[i] = new LinkedList<>();
            minCost[i] = 100_000L * 100_000 + 1;
            optPaths[i] = new LinkedList<>();
        }
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            al[src].add(new Info(dest, cost));
        }
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        br.close();
    }

    public static void dijkstra(int src) {
        PriorityQueue<Status> pq = new PriorityQueue<>();
        pq.add(new Status(src, 0, new LinkedList<>(List.of(src))));
        while(!pq.isEmpty()) {
            Status curStatus = pq.poll();
            int curIndex = curStatus.getIndex();
            long curMinCost = curStatus.getMinCost();
            List<Integer> curOptPath = curStatus.getOptPath();
            if(minCost[curIndex] < curMinCost) continue;
            for(Info info : al[curIndex]) {
                int nextIndex = info.getDest();
                int nextCost = info.getCost();
                if(minCost[nextIndex] > curMinCost + nextCost) {
                    minCost[nextIndex] = curMinCost + nextCost;
                    List<Integer> nextPath = new LinkedList<>(curOptPath);
                    nextPath.add(nextIndex);
                    pq.add(new Status(nextIndex, minCost[nextIndex], nextPath));
                    optPaths[nextIndex] = nextPath;
                }
            }
        }
    }

    private static String getPathString(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for(int index : path) {
            sb.append(index).append(" ");
        }
        return sb.toString();
    }
}