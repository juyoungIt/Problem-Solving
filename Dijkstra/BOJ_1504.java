// BOJ - 1504
// Problem Sheet - https://www.acmicpc.net/problem/1504

import java.util.*;
import java.io.*;

public class Main {

    static class Vertex implements Comparable<Vertex> {
        private final int target;
        private final int dist;

        public Vertex(int target, int dist) {
            this.target = target;
            this.dist = dist;
        }

        public int getTarget() { return this.target; }
        public int getDist() { return this.dist; }

        @Override
        public int compareTo(Vertex v) {
            return this.dist - v.getDist();
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        List<Vertex>[] al = new List[n + 1];
        for(int i=1 ; i<=n ; i++) {
            al[i] = new LinkedList<>();
        }
        for(int i=0 ; i<e ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            al[a].add(new Vertex(b, c));
            al[b].add(new Vertex(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] partA = dijkstra(al, 1);
        int[] partB = dijkstra(al, v1);
        int[] partC = dijkstra(al, n);

        int candidate1 = isValid(partA[v1], partB[v2], partC[v2]);
        int candidate2 = isValid(partA[v2], partB[v2], partC[v1]);
        if(candidate1 > 0 && candidate2 > 0) {
            System.out.println(Math.min(candidate1, candidate2));
        } else if(candidate1 > 0) {
            System.out.println(candidate1);
        } else if(candidate2 > 0) {
            System.out.println(candidate2);
        } else {
            System.out.println(-1);
        }

        br.close();
        System.exit(0);
    }

    private static int[] dijkstra(List<Vertex>[] al, int src) {
        int[] minDist = new int[al.length];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.add(new Vertex(src, 0));
        while(!pq.isEmpty()) {
            Vertex v = pq.poll();
            if(minDist[v.getTarget()] <= v.getDist()) {
                continue;
            }
            minDist[v.getTarget()] = v.getDist();
            for(Vertex cv : al[v.getTarget()]) {
                pq.add(new Vertex(cv.getTarget(), v.getDist() + cv.getDist()));
            }
        }
        return minDist;
    }

    private static int isValid(int minDistA, int minDistB, int minDistC) {
        if(minDistA != Integer.MAX_VALUE
                && minDistB != Integer.MAX_VALUE
                && minDistC != Integer.MAX_VALUE) {
            return minDistA + minDistB + minDistC;
        }
        return -1;
    }
}