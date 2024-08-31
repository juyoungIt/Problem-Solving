// BOJ - 2548
// Problem Sheet - https://www.acmicpc.net/problem/2548

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        int start = 0;
        int end = numbers.length - 1;
        int minSum = Integer.MAX_VALUE;
        int targetIndex = numbers.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int curDiff = getDiff(numbers, mid);
            if (curDiff <= minSum) {
                targetIndex = mid;
                minSum = curDiff;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(numbers[targetIndex]);

        br.close();
        System.exit(0);
    }

    private static int getDiff(int[] arr, int index) {
        int diff = 0;
        for (int i=0 ; i<arr.length ; i++) {
            diff += Math.abs(arr[i] - arr[index]);
        }
        return diff;
    }
}