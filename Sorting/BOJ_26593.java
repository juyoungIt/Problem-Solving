// BOJ - 26593
// Problem Sheet - https://www.acmicpc.net/problem/26593

import java.util.*;
import java.io.*;

public class Main {

    static class Item implements Comparable<Item> {
        String name;
        int saleCount;
        double price;

        public Item(String name, int saleCount, double price) {
            this.name = name;
            this.saleCount = saleCount;
            this.price = price;
        }

        double getSalePrice() { return price * saleCount; }

        @Override
        public int compareTo(Item i) {
            double salePriceA = getSalePrice();
            double salePriceB = i.getSalePrice();
            if (salePriceA == salePriceB) {
                if (saleCount == i.saleCount) {
                    return name.compareTo(i.name);
                }
                return i.saleCount - saleCount;
            }
            return Double.compare(salePriceB, salePriceA);
        }
    }

    static final String OUTPUT_FORMAT = "$%.2f - %s/%d\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Item> items = new ArrayList<>();
        while (true) {
            String input = br.readLine();
            if (input == null) break;
            String[] row = input.split(" ");
            String name = row[0];
            int saleCount = Integer.parseInt(row[1]);
            double price = Double.parseDouble(row[2]);
            items.add(new Item(name, saleCount, price));
        }
        Collections.sort(items);
        for (Item item : items) {
            sb.append(String.format(OUTPUT_FORMAT, item.getSalePrice(), item.name, item.saleCount));
        }
        System.out.println(sb);
        br.close();
    }
}