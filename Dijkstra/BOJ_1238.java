// BOJ - 1238
// Problem Sheet - https://www.acmicpc.net/problem/1238

import java.util.*;
import java.io.*;

public class Main {

    static class Route {
        final int dest;
        final int cost;

        public Route(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    static int n, m, x;
    static List<Route>[] al;
    static final int INF = 1_000_001;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        n = Integer.parseInt(row[0]);
        m = Integer.parseInt(row[1]);
        x = Integer.parseInt(row[2]);
        al = new ArrayList[n + 1];
        for (int i=1 ; i<=n ; i++) {
            al[i] = new ArrayList<>();
        }
        for (int i=0 ; i<m ; i++) {
            row = br.readLine().split(" ");
            int dept = Integer.parseInt(row[0]);
            int dest = Integer.parseInt(row[1]);
            int time = Integer.parseInt(row[2]);
            al[dept].add(new Route(dest, time));
        }
        br.close();
    }

    private static int solve() {
        int[] costForA = new int[n + 1];
        for (int i=1 ; i<=n ; i++) {
            if (i == x) continue;
            int[] cost = dijkstra(i);
            costForA[i] = cost[x];
        }
        int[] costForR = dijkstra(x);
        int maxCost = 0;
        for (int i=1 ; i<=n ; i++) {
            maxCost = Math.max(maxCost, costForA[i] + costForR[i]);
        }
        return maxCost;
    }

    private static int[] dijkstra(int s) {
        int[] cost = new int[n + 1];
        Arrays.fill(cost, INF);
        PriorityQueue<Route> pq = new PriorityQueue<>(Comparator.comparingInt(r -> r.cost));
        pq.add(new Route(s, 0));
        cost[s] = 0;
        while (!pq.isEmpty()) {
            Route cur = pq.poll();
            if (cost[cur.dest] < cur.cost) continue;
            for (Route next : al[cur.dest]) {
                if (cost[next.dest] > cost[cur.dest] + next.cost) {
                    cost[next.dest] = cost[cur.dest] + next.cost;
                    pq.add(new Route(next.dest, cost[next.dest]));
                }
            }
        }
        return cost;
    }

}