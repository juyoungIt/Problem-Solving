// BOJ - 26975
// Problem Sheet - https://www.acmicpc.net/problem/26975

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int maxValue = 0;
        int[] arr = new int[N];
        for (int i=0 ; i<N ; i++) {
            int value = Integer.parseInt(input[i]);
            maxValue = Math.max(value, maxValue);
            arr[i] = value;
        }
        Arrays.sort(arr);

        long maxTotal = 0;
        int opt = 0;
        for (int i=1 ; i<=maxValue ; i++) {
            int lowerBoundIndex = getLowerBoundIndex(arr, i);
            long total = (long) i * (N - lowerBoundIndex);
            if (total > maxTotal) {
                maxTotal = total;
                opt = i;
            }
        }

        System.out.printf("%d %d\n", maxTotal, opt);
        br.close();
    }

    private static int getLowerBoundIndex(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int lowerBoundIndex = arr.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) {
                lowerBoundIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return lowerBoundIndex;
    }
}