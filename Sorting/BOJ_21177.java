// BOJ - 21177
// Problem Sheet - https://www.acmicpc.net/problem/21177

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cards = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        long totalSum = cards[0];
        for (int i=1 ; i<n ; i++) {
            if (cards[i] - 1 == cards[i - 1]) {
                continue;
            }
            totalSum += cards[i];
        }

        System.out.println(totalSum);
        br.close();
    }
}