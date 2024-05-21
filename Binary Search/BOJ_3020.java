// BOJ - 3020
// Problem Sheet - https://www.acmicpc.net/problem/3020

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] stalagmites = new int[n / 2]; // 석순
        int[] stalactites = new int[n / 2]; // 종유석
        int lastIndexOfA = 0;
        int lastIndexOfB = 0;
        for (int i=1 ; i<=n ; i++) {
            if (i % 2 == 1) stalagmites[lastIndexOfA++] = Integer.parseInt(br.readLine());
            else stalactites[lastIndexOfB++] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(stalagmites);
        Arrays.sort(stalactites);

        int minCrashCount = n;
        int dupleCount = 0;
        for (int i=1 ; i<=h ; i++) {
            int totalCrashCount = getCrashCount(stalagmites, i)
                    + getCrashCount(stalactites, h-i+1);
            if (totalCrashCount == minCrashCount) {
                dupleCount++;
                continue;
            }
            if (totalCrashCount < minCrashCount) {
                minCrashCount = totalCrashCount;
                dupleCount = 1;
            }
        }

        System.out.printf("%d %d\n", minCrashCount, dupleCount);

        br.close();
        System.exit(0);
    }

    private static int getCrashCount(int[] arr, int section) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= section) right = mid;
            else left = mid + 1;
        }
        return arr.length - right;
    }
}