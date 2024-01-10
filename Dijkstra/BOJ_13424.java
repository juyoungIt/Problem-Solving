// BOJ - 13424
// Problem Sheet - https://www.acmicpc.net/problem/13424

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int m;
    private static List<Room>[] al;
    private static int[] friendLocations;
    private static int[][] optLength;
    private static final int INFINITE = 5_000_000;

    static class Room {
        private final int dest;
        private final int length;

        public Room(int dest, int length) {
            this.dest = dest;
            this.length = length;
        }

        public int getDest() { return this.dest; }
        public int getLength() { return this.length; }
    }

    static class Status implements Comparable<Status> {
        private final int dest;
        private final int optLength;

        public Status(int dest, int optLength) {
            this.dest = dest;
            this.optLength = optLength;
        }

        public int getDest() { return this.dest; }
        public int getOptLength() { return this.optLength; }

        @Override
        public int compareTo(Status s) {
            return this.optLength - s.getOptLength();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int i=0 ; i<t ; i++) {
            setup(br);
            for(int j=1 ; j<=n ; j++) {
                dijkstra(j);
            }
            int minLength = INFINITE;
            int optLocation = 0;
            for(int j=1 ; j<=n ; j++) {
                int totalLength = 0;
                for(int location : friendLocations) {
                    totalLength += optLength[j][location];
                }
                if(minLength > totalLength) {
                    minLength = totalLength;
                    optLocation = j;
                }
            }
            sb.append(optLocation).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static void setup(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        al = new List[n + 1];
        optLength = new int[n + 1][n + 1];
        for(int i=1 ; i<=n ; i++) {
            al[i] = new LinkedList<>();
            for(int j=1 ; j<=n ; j++) {
                optLength[i][j] = INFINITE;
            }
        }
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            al[a].add(new Room(b, c));
            al[b].add(new Room(a, c));
        }
        int k = Integer.parseInt(br.readLine());
        friendLocations = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k ; i++) {
            friendLocations[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void dijkstra(int src) {
        PriorityQueue<Status> pq = new PriorityQueue<>();
        pq.add(new Status(src, 0));
        optLength[src][src] = 0;
        while(!pq.isEmpty()) {
            Status curStatus = pq.poll();
            int curDest = curStatus.getDest();
            int curOptLength = curStatus.getOptLength();
            if(optLength[src][curDest] < curOptLength) continue;
            for(Room next : al[curDest]) {
                int nextDest = next.getDest();
                int nextLength = next.getLength();
                if(optLength[src][nextDest] > curOptLength + nextLength) {
                    optLength[src][nextDest] = curOptLength + nextLength;
                    pq.add(new Status(nextDest, optLength[src][nextDest]));
                }
            }
        }
    }
}