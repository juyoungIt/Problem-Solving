// BOJ - 16471
// Problem Sheet - https://www.acmicpc.net/problem/16471

import java.util.*;
import java.io.*;

public class Main {

    enum Result {
        YES, NO
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int criteria = (N + 1) / 2;
        int[] cardsA = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .limit(criteria)
                .toArray();
        int[] cardsB = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted(Collections.reverseOrder())
                .limit(criteria)
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();

        int winningCount = 0;
        for (int i=0 ; i<criteria ; i++) {
            if (cardsA[i] < cardsB[i]) {
                winningCount++;
            }
        }

        System.out.println(winningCount >= criteria ? Result.YES : Result.NO);

        br.close();
    }
}