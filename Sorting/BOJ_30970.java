// BOJ - 30970
// Problem Sheet - https://www.acmicpc.net/problem/30970

import java.util.*;
import java.io.*;

public class Main {

    static class Product {
        private final int quality;
        private final int price;

        public Product(int quality, int price) {
            this.quality = quality;
            this.price = price;
        }

        public int getQuality() { return this.quality; }
        public int getPrice() { return this.price; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Product> products = new ArrayList<>(N);
        while (N-- > 0) {
            String[] input = br.readLine().split(" ");
            int q = Integer.parseInt(input[0]);
            int p = Integer.parseInt(input[1]);
            products.add(new Product(q, p));
        }

        // 첫번째 기준 정렬
        products.sort((p1, p2) -> {
            if (p1.getQuality() == p2.getQuality()) {
                return p1.getPrice() - p2.getPrice();
            }
            return p2.getQuality() - p1.getQuality();
        });
        Product first = products.get(0);
        Product second = products.get(1);
        sb.append(String.format(
                "%d %d %d %d\n",
                first.getQuality(),
                first.getPrice(),
                second.getQuality(),
                second.getPrice())
        );

        // 두번째 기준 정렬
        products.sort((p1, p2) -> {
            if (p1.getPrice() == p2.getPrice()) {
                return p2.getQuality() - p1.getQuality();
            }
            return p1.getPrice() - p2.getPrice();
        });
        first = products.get(0);
        second = products.get(1);
        sb.append(String.format(
                "%d %d %d %d\n",
                first.getQuality(),
                first.getPrice(),
                second.getQuality(),
                second.getPrice())
        );

        System.out.println(sb);
        br.close();
    }
}