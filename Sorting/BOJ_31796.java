// BOJ - 31796
// Problem Sheet - https://www.acmicpc.net/problem/31796

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] prices = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int minPriceInPage = prices[0];
        int pageCount = 1;
        for (int i=1 ; i<N ; i++) {
            if (minPriceInPage * 2 <= prices[i]) {
                pageCount++;
                minPriceInPage = prices[i];
            }
        }

        System.out.println(pageCount);

        br.close();
    }
}