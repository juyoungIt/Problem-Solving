// BOJ - 13959
// Problem Sheet - https://www.acmicpc.net/problem/13959

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int d = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        br.close();

        int sum = r + t;
        int ritaCount = 0;
        int ritaAge = d + 3;
        while (true) {
            int theoAge = ritaAge - d;
            int totalSumOfRita = getTotalSumOfRita(ritaAge);
            int totalSumOfTheo = getTotalSumOfTheo(theoAge);
            int totalSum = totalSumOfRita + totalSumOfTheo;
            if (totalSum == sum) {
                ritaCount = totalSumOfRita;
                break;
            }
            if (totalSum > sum) {
                break;
            }
            ritaAge++;
        }
        int candlesToRemove = r - ritaCount;
        System.out.println(candlesToRemove);
    }

    private static int getTotalSumOfRita(int curAge) {
        return curAge * (curAge + 1) / 2 - 6;
    }

    private static int getTotalSumOfTheo(int curAge) {
        return curAge * (curAge + 1) / 2 - 3;
    }

}
