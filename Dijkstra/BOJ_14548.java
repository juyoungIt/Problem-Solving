// BOJ - 14548
// Problem Sheet - https://www.acmicpc.net/problem/14548

import java.util.*;
import java.io.*;

public class Main {

    private static int p;
    private static String dept;
    private static String dest;
    private static Map<String, List<Status>> al;
    private static Map<String, Integer> optDists;

    static class Status implements Comparable<Status> {
        private final String dest;
        private final int optDist;

        public Status(String dest, int optDist) {
            this.dest = dest;
            this.optDist = optDist;
        }

        public String getDest() { return this.dest; }
        public int getOptDist() { return this.optDist; }

        @Override
        public int compareTo(Status s) {
            return this.optDist - s.getOptDist();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        p = Integer.parseInt(br.readLine());
        for(int i=0 ; i<p ; i++) {
            setup(br);
            dijkstra(dept);
            sb.append(String.format("%s %s %d\n", dept, dest, optDists.get(dest)));
        }
        System.out.println(sb);
        br.close();
    }

    private static void setup(BufferedReader br) throws IOException {
        StringTokenizer st;
        al = new HashMap<>();
        optDists = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        dept = st.nextToken();
        dest = st.nextToken();
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            String dept = st.nextToken();
            String dest = st.nextToken();
            int dist = Integer.parseInt(st.nextToken());
            if(al.get(dept) == null) {
                al.put(dept, new LinkedList<>());
                optDists.put(dept, Integer.MAX_VALUE);
            }
            if(al.get(dest) == null) {
                al.put(dest, new LinkedList<>());
                optDists.put(dest, Integer.MAX_VALUE);
            }
            al.get(dept).add(new Status(dest, dist));
            al.get(dest).add(new Status(dept, dist));
        }
    }

    private static void dijkstra(String src) {
        PriorityQueue<Status> pq = new PriorityQueue<>();
        pq.add(new Status(src, 0));
        optDists.put(src, 0);
        while(!pq.isEmpty()) {
            Status curStatus = pq.poll();
            String curDest = curStatus.getDest();
            int curOptDist = curStatus.getOptDist();
            if(optDists.get(curDest) < curOptDist) continue;
            for(Status nextStatus : al.get(curDest)) {
                String nextDest = nextStatus.getDest();
                int nextDist = nextStatus.getOptDist();
                if(optDists.get(nextDest) > curOptDist + nextDist) {
                    optDists.put(nextDest, curOptDist + nextDist);
                    pq.add(new Status(nextDest, optDists.get(nextDest)));
                }
            }
        }
    }
}