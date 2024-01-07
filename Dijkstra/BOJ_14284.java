// BOJ - 14284
// Problem Sheet - https://www.acmicpc.net/problem/14284

import java.util.*;
import java.io.*;

public class Main {

    private static int s;
    private static int t;
    private static List<Status>[] al;
    private static int[] minWeight;

    static class Status implements Comparable<Status> {
        private final int index;
        private final int minWeight;

        public Status(int index, int minWeight) {
            this.index = index;
            this.minWeight = minWeight;
        }

        public int getIndex() { return this.index; }
        public int getMinWeight() { return this.minWeight; }

        @Override
        public int compareTo(Status s) {
            return this.minWeight - s.getMinWeight();
        }
    }

    public static void main(String[] args) throws IOException {
        setup();
        dijkstra(s);
        System.out.println(minWeight[t]);
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        al = new List[n + 1];
        minWeight = new int[n + 1];
        for(int i = 1; i<= n; i++) {
            al[i] = new LinkedList<>();
            minWeight[i] = 100_000 * 100 + 1;
        }

        for(int i = 0; i< m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            al[a].add(new Status(b, c));
            al[b].add(new Status(a, c));
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        br.close();
    }

    private static void dijkstra(int src) {
        PriorityQueue<Status> pq = new PriorityQueue<>();
        pq.add(new Status(src, 0));
        while(!pq.isEmpty()) {
            Status curStatus = pq.poll();
            int curIndex = curStatus.getIndex();
            int curMinWeight = curStatus.getMinWeight();
            if(minWeight[curIndex] < curMinWeight) continue;
            for(Status nextStatus : al[curIndex]) {
                int nextIndex = nextStatus.getIndex();
                int nextWeight = nextStatus.getMinWeight();
                if(minWeight[nextIndex] > curMinWeight + nextWeight) {
                    minWeight[nextIndex] = curMinWeight + nextWeight;
                    pq.add(new Status(nextIndex, minWeight[nextIndex]));
                }
            }
        }
    }
}