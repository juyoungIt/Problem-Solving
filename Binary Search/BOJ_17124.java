// BOJ - 17124
// Problem Sheet - https://www.acmicpc.net/problem/17124

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arrA = new int[n];
            int[] arrB = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int j=0 ; j<n ; j++) {
                arrA[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j=0 ; j<m ; j++) {
                arrB[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrB);

            sb.append(getNewArrSum(arrA, arrB)).append("\n");
        }
        System.out.println(sb);

        br.close();
    }

    private static long getNewArrSum(int[] arrA, int[] arrB) {
        long elementSum = 0L;
        for (int element : arrA) {
            elementSum += getClosestElement(arrB, element);
        }
        return elementSum;
    }

    private static int getClosestElement(int[] arrB, int target) {
        int start = 0;
        int end = arrB.length - 1;
        int minDiff = 1_000_000_000;
        int closestElement = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int diff = arrB[mid] - target;
            if (Math.abs(diff) < minDiff) {
                minDiff = Math.abs(diff);
                closestElement = arrB[mid];
            } else if (Math.abs(diff) == minDiff && arrB[mid] < closestElement) {
                closestElement = arrB[mid];
            }
            if (diff == 0) {
                return arrB[mid];
            } else if (diff < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return closestElement;
    }
}