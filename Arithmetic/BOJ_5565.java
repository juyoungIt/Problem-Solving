// BOJ - 5565
// Problem Sheet - https://www.acmicpc.net/problem/5565

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int totalPrice = Integer.parseInt(bf.readLine());
        List<Integer> prices = new ArrayList<>(9);
        for(int i=0 ; i<9 ; i++) {
            prices.add(Integer.parseInt(bf.readLine()));
        }

        System.out.println(totalPrice - getTotalSum(prices));

        bf.close();
        System.exit(0);
    }

    private static int getTotalSum(List<Integer> prices) {
        int sum = 0;
        for(int i=0 ; i<9 ; i++) {
            sum += prices.get(i);
        }
        return sum;
    }
}