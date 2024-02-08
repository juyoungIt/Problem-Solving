// BOJ - 12442
// Problem Sheet - https://www.acmicpc.net/problem/12442

import java.util.*;
import java.io.*;

public class Main {

    private static int n, p, m;
    private static int[][] friends;
    private static List<Node>[] al;
    private static int[][] optDists;
    private static final int INFINITE = Integer.MAX_VALUE;

    static class Node {
        private final int dest;
        private final int dist;

        public Node(int dest, int dist) {
            this.dest = dest;
            this.dist = dist;
        }

        public int getDest() { return this.dest; }
        public int getDist() { return this.dist; }
    }

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
            return Integer.compare(this.optDist, s.getOptDist());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int i=1 ; i<=t ; i++) {
            setup(br);
            for(int j=1 ; j<=p ; j++) {
                if(optDists[friends[j][0]][friends[j][0]] > 0) {
                    dijkstra(friends[j][0]);
                }
            }
            long minTotalCost = INFINITE;
            for(int j=1 ; j<=n ; j++) {
                int totalCost = getTotalCost(j);
                if(totalCost >= 0 && minTotalCost > totalCost) {
                    minTotalCost = totalCost;
                }
            }
            sb.append(String.format("Case #%d: %d\n", i, minTotalCost < INFINITE ? minTotalCost : -1));
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static void setup(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        optDists = new int[n + 1][n + 1];
        friends = new int[p + 1][2];
        for(int i=1 ; i<=p ; i++) {
            st = new StringTokenizer(br.readLine());
            friends[i][0] = Integer.parseInt(st.nextToken());
            friends[i][1] = Integer.parseInt(st.nextToken());
        }

        al = new List[n + 1];
        for(int i=1 ; i<=n ; i++) {
            al[i] = new LinkedList<>();
            Arrays.fill(optDists[i], INFINITE);
        }
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int dist = Integer.parseInt(st.nextToken());
            int connectedCnt = Integer.parseInt(st.nextToken());
            int prevCity = 0, curCity;
            for(int j=0 ; j<connectedCnt ; j++) {
                curCity = Integer.parseInt(st.nextToken());
                if(j == 0) {
                    prevCity = curCity;
                    continue;
                }
                al[prevCity].add(new Node(curCity, dist));
                al[curCity].add(new Node(prevCity, dist));
                prevCity = curCity;
            }
        }
    }

    private static void dijkstra(int src) {
        PriorityQueue<Status> pq = new PriorityQueue<>();
        pq.add(new Status(src, 0));
        optDists[src][src] = 0;
        while(!pq.isEmpty()) {
            Status curStatus = pq.poll();
            int curDest = curStatus.getDest();
            int curOptDist = curStatus.getOptDist();
            if(optDists[src][curDest] < curOptDist) continue;
            for(Node nextNode : al[curDest]) {
                int nextDest = nextNode.getDest();
                int nextDist = nextNode.getDist();
                if(optDists[src][nextDest] > curOptDist + nextDist) {
                    optDists[src][nextDest] = curOptDist + nextDist;
                    pq.add(new Status(nextDest, optDists[src][nextDest]));
                }
            }
        }
    }

    private static int getTotalCost(int meetingPlace) {
        int totalCost = 0;
        for(int[] friend : friends) {
            int dept = friend[0];
            int unitCost = friend[1];
            if(optDists[dept][meetingPlace] == INFINITE) {
                totalCost = -1;
                break;
            }
            totalCost = Math.max(totalCost, optDists[dept][meetingPlace] * unitCost);
        }
        return totalCost;
    }
}