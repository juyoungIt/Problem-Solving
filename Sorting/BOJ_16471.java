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
        int[] cardsA = new int[N];
        int[] cardsB = new int[N];
        StringTokenizer sta = new StringTokenizer(br.readLine());
        StringTokenizer stb = new StringTokenizer(br.readLine());
        for (int i=0 ; i<N ; i++) {
            cardsA[i] = Integer.parseInt(sta.nextToken());
            cardsB[i] = Integer.parseInt(stb.nextToken());
        }
        Arrays.sort(cardsA);
        Arrays.sort(cardsB);

        int winningCount = 0;
        int index = 0;
        for (int i=0 ; i<N ; i++) {
            if (cardsA[index] < cardsB[i]) {
                index++;
                winningCount++;
            }
        }

        System.out.println(winningCount >= criteria ? Result.YES : Result.NO);

        br.close();
    }
}