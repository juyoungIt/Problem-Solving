// BOJ - 1162
// Problem Sheet - https://www.acmicpc.net/problem/1162

import java.util.*;
import java.io.*;

public class Main {

    static class Route {
        final int dest;
        final long time;
        final int covered;

        public Route(int dest, long time, int covered) {
            this.dest = dest;
            this.time = time;
            this.covered = covered;
        }
    }

    static final long INF = 10_000_000_001L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] row = br.readLine().split(" ");
        int n = Integer.parseInt(row[0]);
        int m = Integer.parseInt(row[1]);
        int k = Integer.parseInt(row[2]);
        long[][] minTime = new long[n + 1][k + 1];
        List<Route>[] al = new ArrayList[n + 1];
        for (int i=1 ; i<=n ; i++) {
            al[i] = new ArrayList<>();
            Arrays.fill(minTime[i], INF);
        }
        for (int i=0 ; i<m ; i++) {
            row = br.readLine().split(" ");
            int ca = Integer.parseInt(row[0]);
            int cb = Integer.parseInt(row[1]);
            int t = Integer.parseInt(row[2]);
            al[ca].add(new Route(cb, t, 0));
            al[cb].add(new Route(ca, t, 0));
        }

        PriorityQueue<Route> pq = new PriorityQueue<>(Comparator.comparingLong(r -> r.time));
        pq.add(new Route(1, 0, 0));
        minTime[1][0] = 0;
        while (!pq.isEmpty()) {
            Route cur = pq.poll();
            if (minTime[cur.dest][cur.covered] < cur.time) continue;
            for (Route next : al[cur.dest]) {
                // 1. 도로를 포장하지 않는 경우
                if (minTime[next.dest][cur.covered] > minTime[cur.dest][cur.covered] + next.time) {
                    minTime[next.dest][cur.covered] = minTime[cur.dest][cur.covered] + next.time;
                    pq.add(new Route(next.dest, minTime[next.dest][cur.covered], cur.covered));
                }
                // 2. 도로를 포장하는 경우
                if (cur.covered + 1 <= k && minTime[next.dest][cur.covered + 1] > minTime[cur.dest][cur.covered]) {
                    minTime[next.dest][cur.covered + 1] = minTime[cur.dest][cur.covered];
                    pq.add(new Route(next.dest, minTime[next.dest][cur.covered + 1], cur.covered + 1));
                }
            }
        }

        long answer = INF;
        for (int i=1 ; i<=k ; i++) {
            answer = Math.min(answer, minTime[n][i]);
        }
        System.out.println(answer);
        br.close();
    }
}