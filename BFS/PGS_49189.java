// PGS - 49189
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/49189

import java.util.*;

class Solution {
    
    private List<List<Integer>> graph;
    private int[] dist;
    
    public int solution(int n, int[][] edge) {
        buildGraph(n, edge);
        dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        dist[1] = 0;
        int maxDist = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int v : graph.get(cur)) {
                if (dist[v] >= 0) continue;
                queue.add(v);
                dist[v] = dist[cur] + 1;
                maxDist = Math.max(maxDist, dist[v]);
            }
        }
        int answer = 0;
        for (int i=1; i<=n; i++) {
            if (dist[i] == maxDist) {
                answer++;
            }
        }
        return answer;
    }
    
    private void buildGraph(int n, int[][] edge) {
        graph = new ArrayList<>(n + 1);
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
    }
}
