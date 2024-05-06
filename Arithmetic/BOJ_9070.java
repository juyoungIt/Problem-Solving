// BOJ - 9070
// Problem Sheet - https://www.acmicpc.net/problem/9070

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            int n = Integer.parseInt(br.readLine());
            double minPricePerWeight = (double) 100_000 / 5_000;
            int answer = 100_000;
            for (int j=0 ; j<n ; j++) {
                st = new StringTokenizer(br.readLine());
                int weight = Integer.parseInt(st.nextToken());
                int price = Integer.parseInt(st.nextToken());
                double pricePerWeight = (double)price / weight;
                if (minPricePerWeight > pricePerWeight
                        || minPricePerWeight == pricePerWeight && answer > price) {
                    minPricePerWeight = pricePerWeight;
                    answer = price;
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}