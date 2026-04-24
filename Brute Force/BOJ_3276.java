// BOJ - 3276
// Problem Sheet - https://www.acmicpc.net/problem/3276

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int optRow = -1, optCol = -1;
        int pairSum = 201;
        for (int i=1 ; i<=100 ; i++) {
            for (int j=1 ; j<=100 ; j++) {
                int sum = i + j;
                if (i * j >= n && pairSum > sum) {
                    optRow = i;
                    optCol = j;
                    pairSum = sum;
                }
            }
        }
        System.out.printf("%d %d\n", optRow, optCol);
        br.close();
    }
}
