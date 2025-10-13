// BOJ - 29896
// Problem Sheet - https://www.acmicpc.net/problem/29896

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> priceMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String product = br.readLine();
            int price = Integer.parseInt(br.readLine());
            priceMap.put(product, price);
        }

        int m = Integer.parseInt(br.readLine());
        long initialCost = 0;
        Map<String, Integer> purchaseCount = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String purchase = br.readLine();
            initialCost += priceMap.get(purchase);
            purchaseCount.put(purchase, purchaseCount.getOrDefault(purchase, 0) + 1);
        }

        long minCost = initialCost;

        String[] products = priceMap.keySet().toArray(new String[0]);
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = i + 1; j < products.length; j++) {
                String productA = products[i];
                String productB = products[j];

                int countA = purchaseCount.getOrDefault(productA, 0);
                int countB = purchaseCount.getOrDefault(productB, 0);

                if (countA == 0 && countB == 0) continue;

                long costChange = (long) (priceMap.get(productB) - priceMap.get(productA)) * countA
                        + (long) (priceMap.get(productA) - priceMap.get(productB)) * countB;

                long newCost = initialCost + costChange;

                minCost = Math.min(minCost, newCost);
            }
        }

        System.out.println(minCost);
        br.close();
    }
}