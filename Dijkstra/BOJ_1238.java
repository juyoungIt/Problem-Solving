// BOJ - 1238
// Problem Sheet - https://www.acmicpc.net/problem/1238

import java.util.*;
import java.io.*;

public class Main {

    static class Info implements Comparable<Info> {
        private final int dest;
        private final int time;

        public Info(int dest, int time) {
            this.dest = dest;
            this.time = time;
        }

        public int getDest() { return this.dest; }
        public int getTime() { return this.time; }

        @Override
        public int compareTo(Info o) {
            return this.time - o.getTime();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[][] minTimes = new int[n + 1][n + 1];
        List<Info>[] al = new List[n + 1];
        for(int i=1 ; i<=n ; i++) {
            Arrays.fill(minTimes[i], Integer.MAX_VALUE);
            al[i] = new LinkedList<>();
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            al[src].add(new Info(dest, time));
        }

        for(int i=1 ; i<=n ; i++) {
            dijkstra(al, i, minTimes);
        }

        int maxTime = 0;
        for(int i=1 ; i<=n ; i++) {
            int time = 0;
            time += minTimes[i][x];
            time += minTimes[x][i];
            if(maxTime < time) {
                maxTime = time;
            }
        }

        System.out.println(maxTime);

        br.close();
        System.exit(0);
    }

    private static void dijkstra(List<Info>[] al, int src, int[][] minTimes) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(src, 0));
        while(!pq.isEmpty()) {
            Info curInfo = pq.poll();
            if(curInfo.getTime() >= minTimes[src][curInfo.getDest()]) continue;
            minTimes[src][curInfo.getDest()] = curInfo.getTime();
            for(Info info : al[curInfo.getDest()]) {
                pq.add(new Info(info.getDest(), minTimes[src][curInfo.getDest()] + info.getTime()));
            }
        }
    }
}