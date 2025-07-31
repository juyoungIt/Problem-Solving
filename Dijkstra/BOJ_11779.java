// BOJ - 1916
// Problem Sheet - https://www.acmicpc.net/problem/1916

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

    static final int INF = 100_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] costs = new int[n + 1];
        List<Route>[] al = new ArrayList[n + 1];
        for (int i=1 ; i<=n ; i++) {
            al[i] = new ArrayList<>();
        }
        Arrays.fill(costs, INF);
        for (int i=0 ; i<m ; i++) {
            String[] row = br.readLine().split(" ");
            int dept = Integer.parseInt(row[0]);
            int dest = Integer.parseInt(row[1]);
            int cost = Integer.parseInt(row[2]);
            al[dept].add(new Route(dest, cost));
        }
        String[] row = br.readLine().split(" ");
        int dept = Integer.parseInt(row[0]);
        int dest = Integer.parseInt(row[1]);

        int[] path = new int[n + 1];
        PriorityQueue<Route> pq = new PriorityQueue<>(Comparator.comparingInt(r -> r.cost));
        pq.add(new Route(dept, 0));
        costs[dept] = 0;
        while (!pq.isEmpty()) {
            Route cur = pq.poll();
            if (costs[cur.dest] < cur.cost) continue;
            for (Route next : al[cur.dest]) {
                if (costs[cur.dest] + next.cost < costs[next.dest]) {
                    costs[next.dest] = costs[cur.dest] + next.cost;
                    pq.add(new Route(next.dest, costs[next.dest]));
                    path[next.dest] = cur.dest;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        int cur = dest;
        while (cur != 0) {
            stack.push(cur);
            cur = path[cur];
        }
        sb.append(costs[dest]).append("\n");
        sb.append(stack.size()).append("\n");
        while (!stack.isEmpty()) sb.append(stack.pop()).append(" ");
        System.out.println(sb);
        br.close();
    }

}