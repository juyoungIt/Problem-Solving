// BOJ - 5972
// Problem Sheet - https://www.acmicpc.net/problem/5972

import java.util.*;
import java.io.*;

public class Main {

    static class PriceInfo implements Comparable<PriceInfo> {
        private final int dest;
        private final int price;

        public PriceInfo(int dest, int price) {
            this.dest = dest;
            this.price = price;
        }

        public int getDest() { return this.dest; }
        public int getPrice() { return this.price; }

        @Override
        public int compareTo(PriceInfo p) {
            return this.price - p.getPrice();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] minDist = new int[n + 1];
        List<PriceInfo>[] al = new List[n + 1];
        for(int i=1 ; i<=n ; i++) {
            al[i] = new LinkedList<>();
            minDist[i] = 50_000_001;
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            al[a].add(new PriceInfo(b, c));
            al[b].add(new PriceInfo(a, c));
        }

        PriorityQueue<PriceInfo> pq = new PriorityQueue<>();
        pq.add(new PriceInfo(1, 0));
        while(!pq.isEmpty()) {
            PriceInfo curPriceInfo = pq.poll();
            for(PriceInfo nextPriceInfo : al[curPriceInfo.getDest()]) {
                int price = curPriceInfo.getPrice() + nextPriceInfo.getPrice();
                if(minDist[nextPriceInfo.getDest()] > price) {
                    minDist[nextPriceInfo.getDest()] = price;
                    pq.add(new PriceInfo(nextPriceInfo.getDest(), price));
                }
            }
        }

        System.out.println(minDist[n]);

        br.close();
        System.exit(0);
    }
}