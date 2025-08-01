// BOJ - 1504
// Problem Sheet - https://www.acmicpc.net/problem/1504

import java.util.*;
import java.io.*;

public class Main {

    static class Route {
        final int dept;
        final int cost;

        public Route(int dept, int cost) {
            this.dept = dept;
            this.cost = cost;
        }
    }

    static int n, e;
    static List<Route>[] al;
    static int v1, v2;
    static final int INF = 200_000_001;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        n = Integer.parseInt(row[0]);
        e = Integer.parseInt(row[1]);
        al = new ArrayList[n + 1];
        for (int i=1 ; i<=n ; i++) {
            al[i] = new ArrayList<>();
        }
        for (int i=0 ; i<e ; i++) {
            row = br.readLine().split(" ");
            int a = Integer.parseInt(row[0]);
            int b = Integer.parseInt(row[1]);
            int c = Integer.parseInt(row[2]);
            al[a].add(new Route(b, c));
            al[b].add(new Route(a, c));
        }
        row = br.readLine().split(" ");
        v1 = Integer.parseInt(row[0]);
        v2 = Integer.parseInt(row[1]);
        br.close();
    }

    private static int solve() {
        int[] costFrom1 = dijkstra(1);
        int[] costFromV1 = dijkstra(v1);
        int[] costFromN = dijkstra(n);
        int costA = costFrom1[v1] + costFromV1[v2] + costFromN[v2];
        int costB = costFrom1[v2] + costFromV1[v2] + costFromN[v1];
        int optCost = Math.min(costA, costB);
        return optCost < INF ? optCost : -1;
    }

    private static int[] dijkstra(int s) {
        int[] cost = new int[n + 1];
        Arrays.fill(cost, INF);
        PriorityQueue<Route> pq = new PriorityQueue<>(Comparator.comparingInt(r -> r.cost));
        pq.add(new Route(s, 0));
        cost[s] = 0;
        while (!pq.isEmpty()) {
            Route cur = pq.poll();
            if (cost[cur.dept] < cur.cost) continue;
            for (Route next : al[cur.dept]) {
                if (cost[next.dept] > cost[cur.dept] + next.cost) {
                    cost[next.dept] = cost[cur.dept] + next.cost;
                    pq.add(new Route(next.dept, cost[next.dept]));
                }
            }
        }
        return cost;
    }
    
}