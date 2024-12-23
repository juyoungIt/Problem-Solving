// BOJ - 26168
// Problem Sheet - https://www.acmicpc.net/problem/26168

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        long[] A = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .sorted()
                .toArray();

        for (int x=0 ; x<m ; x++) {
            input = br.readLine().split(" ");
            int command = Integer.parseInt(input[0]);
            if (command == 1) {
                long k = Long.parseLong(input[1]);
                int lowerBoundIndex = getLowerBoundIndex(A, k);
                sb.append(n - lowerBoundIndex).append("\n");
            } else if (command == 2) {
                long k = Long.parseLong(input[1]);
                int upperBoundIndex = getUpperBoundIndex(A, k);
                sb.append(n - upperBoundIndex).append("\n");
            } else {
                long i = Long.parseLong(input[1]);
                long j = Long.parseLong(input[2]);
                int lowerBoundIndex = getLowerBoundIndex(A, i);
                int upperBoundIndex = getUpperBoundIndex(A, j);
                sb.append(upperBoundIndex - lowerBoundIndex).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    private static int getLowerBoundIndex(long[] arr, long target) {
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

    public static int getUpperBoundIndex(long[] arr, long target) {
        int start = 0;
        int end = arr.length - 1;
        int upperBoundIndex = arr.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) {
                upperBoundIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return upperBoundIndex;
    }
}