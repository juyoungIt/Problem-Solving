// BOJ - 6032
// Problem Sheet - https://www.acmicpc.net/problem/6032

import java.util.*;
import java.io.*;

public class Main {

    static class Toy implements Comparable<Toy> {
        private final int index;
        private final int joy;
        private final int price;

        public Toy(int index, int joy, int price) {
            this.index = index;
            this.joy = joy;
            this.price = price;
        }

        public int getIndex() { return this.index; }
        public int getPrice() { return this.price; }
        public double getHappyMetric() { return (double) this.joy / this.price; }

        @Override
        public int compareTo(Toy t) {
            return Double.compare(t.getHappyMetric(), this.getHappyMetric());
        }

        @Override
        public String toString() {
            return "Toy{" +
                    "index=" + index +
                    ", joy=" + joy +
                    ", price=" + price +
                    ", metric=" + getHappyMetric() +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Toy> toys = new PriorityQueue<>(N);
        for (int i=1 ; i<=N ; i++) {
            String[] input = br.readLine().split(" ");
            int j = Integer.parseInt(input[0]);
            int p = Integer.parseInt(input[1]);
            toys.add(new Toy(i, j, p));
        }

        int toyCount = 0;
        int[] results = new int[4];
        while (toyCount < 3 && !toys.isEmpty()) {
            Toy toy = toys.poll();
            results[0] += toy.getPrice();
            results[++toyCount] = toy.getIndex();
        }

        for (int result : results) {
            sb.append(result).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}