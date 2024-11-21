// BOJ - 21194
// Problem Sheet - https://www.acmicpc.net/problem/21194

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] scores = new int[n];
        for (int i=0 ; i<n ; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(scores);

        int maxScoreSum = 0;
        for (int i=n-1 ; i>n-1-k ; i--) {
            maxScoreSum += scores[i];
        }

        System.out.println(maxScoreSum);
        br.close();
    }
}