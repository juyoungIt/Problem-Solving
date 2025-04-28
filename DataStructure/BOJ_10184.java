// BOJ - 10184
// Problem Sheet - https://www.acmicpc.net/problem/10184

import java.util.*;
import java.io.*;

public class Main {

    private static final String INVALID = "INVALID COUPONS";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] row = br.readLine().split(" ");
            int x = Integer.parseInt(row[0]);
            int y = Integer.parseInt(row[1]);
            Map<String, Double> productMap = new HashMap<>();
            Map<String, Double> couponMap = new LinkedHashMap<>();
            for (int i=0 ; i<x ; i++) {
                row = br.readLine().split(" ");
                String upcCode = row[0];
                double price = Double.parseDouble(row[1]);
                productMap.put(upcCode, price);
            }
            for (int i=0 ; i<y ; i++) {
                row = br.readLine().split(" ");
                String upcCode = row[0];
                double discountRate = Double.parseDouble(row[1]);
                couponMap.put(upcCode, discountRate);
            }
            double totalSum = 0.0;
            for(Map.Entry<String, Double> entry : productMap.entrySet()) {
                totalSum += entry.getValue() * (1 - couponMap.getOrDefault(entry.getKey(), 0.0));
            }
            sb.append(String.format("%.2f", totalSum)).append("\n");
            boolean invalidCoupon = false;
            for (String upcCode : couponMap.keySet()) {
                if (!productMap.containsKey(upcCode)) {
                    if (!invalidCoupon) {
                        sb.append(INVALID).append("\n");
                        invalidCoupon = true;
                    }
                    sb.append(upcCode).append("\n");
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}