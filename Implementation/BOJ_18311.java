// BOJ - 18311
// Problem Sheet - https://www.acmicpc.net/problem/18311

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long[] forwardAcc = new long[n + 1];
        long[] reverseAcc = new long[n + 1];
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i=1 ; i<=n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        for (int i=1 ; i<=n ; i++) {
            forwardAcc[i] = forwardAcc[i - 1] + arr[i];
            reverseAcc[i] = reverseAcc[i - 1] + arr[n + 1 - i];
        }
        if (k <= forwardAcc[n]) {
            int course = findUpperBoundIndex(forwardAcc, k);
            System.out.println(course);
        } else {
            int course = findUpperBoundIndex(reverseAcc, k - forwardAcc[n]);
            System.out.println(n - course + 1);
        }
    }

    private static int findUpperBoundIndex(long[] arr, long target) {
        int start = 0, end = arr.length - 1;
        int upperBoundIndex = end;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
                upperBoundIndex = mid;
            } else {
                start = mid + 1;
            }
        }
        return upperBoundIndex;
    }
}
