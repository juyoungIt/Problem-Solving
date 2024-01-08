// BOJ - 14284
// Problem Sheet - https://www.acmicpc.net/problem/14284

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int v;
    private static int A;
    private static int B;
    private static int[] home;
    private static int[] minDist;
    private static int[] optDist;
    private static List<Status>[] al;
    private static final int INFINITE = 10_000 * 100 + 1;

    static class Status implements Comparable<Status> {
        private final int index;
        private final int minDist;

        public Status(int index, int minDist) {
            this.index = index;
            this.minDist = minDist;
        }

        public int getIndex() { return this.index; }
        public int getMinDist() { return this.minDist; }

        @Override
        public int compareTo(Status s) {
            return this.minDist - s.getMinDist();
        }
    }

    public static void main(String[] args) throws IOException {
        setup();
        for(int i=0 ; i<n ; i++) {
            dijkstra(home[i]);
            optDist[i] = getOptDist();
        }
        System.out.println(Arrays.stream(optDist).mapToLong(dist -> (long)dist).sum());
        System.exit(0);
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        home = new int[n];
        optDist = new int[n];
        minDist = new int[v + 1];
        al = new List[v + 1];
        for(int i=1 ; i<=v ; i++) {
            al[i] = new LinkedList<>();
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            home[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i< e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            al[a].add(new Status(b, l));
            al[b].add(new Status(a, l));
        }

        br.close();
    }

    private static void dijkstra(int src) {
        Arrays.fill(minDist, INFINITE);
        PriorityQueue<Status> pq = new PriorityQueue<>();
        pq.add(new Status(src, 0));
        minDist[src] = 0;
        while(!pq.isEmpty()) {
            Status curStatus = pq.poll();
            int curIndex = curStatus.getIndex();
            int curMinDist = curStatus.getMinDist();
            if(minDist[curIndex] < curMinDist) continue;
            for(Status nextStatus : al[curIndex]) {
                int nextIndex = nextStatus.getIndex();
                int nextDist = nextStatus.getMinDist();
                if(minDist[nextIndex] > curMinDist + nextDist) {
                    minDist[nextIndex] = curMinDist + nextDist;
                    pq.add(new Status(nextIndex, minDist[nextIndex]));
                }
            }
        }
    }

    private static int getOptDist() {
        return ((minDist[A] == INFINITE) ? -1 : minDist[A])
                + ((minDist[B] == INFINITE) ? -1 : minDist[B]);
    }
}