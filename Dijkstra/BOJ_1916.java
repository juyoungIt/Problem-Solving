// BOJ - 1916
// Problem Sheet - https://www.acmicpc.net/problem/1916

import java.util.*;
import java.io.*;

public class Main {

    static class BusInfo {
        private final int dest;
        private final int price;

        public BusInfo(int dest, int price) {
            this.dest = dest;
            this.price = price;
        }

        public int getDest() { return this.dest; }
        public int getPrice() { return this.price; }
    }

    static class PriceInfo implements Comparable<PriceInfo> {
        private final int dest;
        private final int minPrice;

        public PriceInfo(int dest, int minPrice) {
            this.dest = dest;
            this.minPrice = minPrice;
        }

        public int getDest() { return this.dest; }
        public int getMinPrice() { return this.minPrice; }

        @Override
        public int compareTo(PriceInfo priceInfo) {
            return this.minPrice - priceInfo.getMinPrice();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] minPrice = new int[n + 1];
        Arrays.fill(minPrice, Integer.MAX_VALUE);
        List<BusInfo>[] al = new List[n + 1];
        for(int i=1 ; i<=n ; i++) {
            al[i] = new LinkedList<>();
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            al[src].add(new BusInfo(dest, price));
        }

        st = new StringTokenizer(br.readLine());
        int src = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());

        PriorityQueue<PriceInfo> pq = new PriorityQueue<>();
        pq.add(new PriceInfo(src, 0));
        while(!pq.isEmpty()) {
            PriceInfo priceInfo = pq.poll();
            if(minPrice[priceInfo.getDest()] <= priceInfo.getMinPrice()) {
                continue;
            }
            minPrice[priceInfo.getDest()] = priceInfo.getMinPrice();
            for(BusInfo busInfo : al[priceInfo.getDest()]) {
                pq.add(new PriceInfo(busInfo.getDest(), busInfo.getPrice() + priceInfo.getMinPrice()));
            }
        }

        System.out.println(minPrice[dest]);

        br.close();
        System.exit(0);
    }
}