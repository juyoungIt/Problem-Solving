// BOJ - 14938
// Problem Sheet - https://www.acmicpc.net/problem/14938

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int m;
    private static int r;
    private static int[] items;
    private static int[] minDist;
    private static List<Info>[] al;

    static class Info implements Comparable<Info> {
        private final int index;
        private final int dist;

        public Info(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        public int getIndex() { return this.index; }
        public int getDist() { return this.dist; }

        @Override
        public int compareTo(Info i) {
            return this.dist - i.getDist();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        items = new int[n + 1];
        minDist = new int[n + 1];
        al = new List[n + 1];
        for(int i=1 ; i<=n ; i++) {
            al[i] = new LinkedList<>();
            minDist[i] = 100 * 15 + 1;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0 ; i<r ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            al[a].add(new Info(b, l));
            al[b].add(new Info(a, l));
        }

        int result = 0;
        for(int i=1 ; i<=n ; i++) {
            result = Math.max(result, dijkstra(i));
        }
        System.out.println(result);

        br.close();
        System.exit(0);
    }

    private static int dijkstra(int src) {
        int accItem = 0;
        for(int i=1 ; i<=n ; i++) {
            minDist[i] = 100 * 15 + 1;
        }
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(src, 0));
        minDist[src] = 0;
        while(!pq.isEmpty()) {
            Info ci = pq.poll();
            for(Info ni : al[ci.getIndex()]) {
                if(minDist[ni.getIndex()] > minDist[ci.getIndex()] + ni.getDist()) {
                    minDist[ni.getIndex()] = minDist[ci.getIndex()] + ni.getDist();
                    pq.add(new Info(ni.getIndex(), minDist[ni.getIndex()]));
                }
            }
        }
        for(int i=1 ; i<=n ; i++) {
            if(minDist[i] <= m) {
                accItem += items[i];
            }
        }
        return accItem;
    }
}