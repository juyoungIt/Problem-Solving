// BOJ - 4809
// Problem Sheet - https://www.acmicpc.net/problem/4809

import java.util.*;
import java.io.*;

public class Main {

    static class StockPrice {
        final int index;
        final int price;

        public StockPrice(int index, int price) {
            this.index = index;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tcIndex = 1;
        while (true) {
            String[] row = br.readLine().split(" ");
            int n = Integer.parseInt(row[0]);
            int k1 = Integer.parseInt(row[1]);
            int k2 = Integer.parseInt(row[2]);
            if (n == 0 && k1 == 0 && k2 == 0) break;
            StockPrice[] stockPrices = new StockPrice[n];
            row = br.readLine().split(" ");
            for (int i=0 ; i<n ; i++) {
                stockPrices[i] = new StockPrice(i + 1, Integer.parseInt(row[i]));
            }
            Arrays.sort(stockPrices, (s1, s2) -> {
                if (s1.price == s2.price) {
                    return s1.index - s2.index;
                }
                return s1.price - s2.price;
            });
            sb.append(String.format("Case %d\n", tcIndex++));
            int[] minK1 = new int[k1];
            for (int i=0 ; i<k1 ; i++) {
                minK1[i] = stockPrices[i].index;
            }
            Arrays.sort(minK1);
            for (int e : minK1) {
                sb.append(e).append(" ");
            }
            sb.append("\n");
            int[] maxK2 = new int[k2];
            for (int i=n-1 ; i>=n-k2 ; i--) {
                maxK2[n-1-i] = stockPrices[i].index;
            }
            Arrays.sort(maxK2);
            for (int i=k2-1 ; i>=0 ; i--) {
                sb.append(maxK2[i]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}