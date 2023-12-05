// BOJ - 1753
// Problem Sheet - https://www.acmicpc.net/problem/1753

import java.util.*;
import java.io.*;

public class Main {

    static class Vertex implements Comparable<Vertex> {
        private final int target;
        private final int weight;

        public Vertex(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        public int getTarget() { return this.target; }
        public int getWeight() { return this.weight; }

        @Override
        public int compareTo(Vertex v) {
            return this.weight - v.getWeight();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        List<Vertex>[] al = new List[V + 1];
        int[] minDist = new int[V + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        for(int i=1 ; i<=V ; i++) {
            al[i] = new LinkedList<>();
        }

        for(int i=0 ; i<E ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            al[u].add(new Vertex(v, w));
        }

        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.add(new Vertex(K, 0));
        while(!pq.isEmpty()) {
            Vertex cur = pq.poll();
            if(minDist[cur.getTarget()] <= cur.getWeight()) {
                continue;
            }
            minDist[cur.getTarget()] = cur.getWeight();
            for(Vertex v : al[cur.getTarget()]) {
                pq.add(new Vertex(v.getTarget(), v.getWeight() + cur.getWeight()));
            }
        }

        for(int i=1 ; i<=V ; i++) {
            if(minDist[i] == Integer.MAX_VALUE) sb.append("INF");
            else sb.append(minDist[i]);
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}