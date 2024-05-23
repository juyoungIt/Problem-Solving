// BOJ - 9024
// Problem Sheet - https://www.acmicpc.net/problem/9024

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
            int k = Integer.parseInt(st.nextToken());
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Arrays.sort(arr);
            sb.append(getCombinationCount(arr, n, k)).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static int getCombinationCount(int[] arr, int n, int k) {
        int combinations = 0;
        int minDiff = 200_000_000;
        for (int i=0 ; i<n ; i++) {
            int start = i+1;
            int end = n-1;
            while (start <= end) {
                int mid = (start + end) / 2;
                int diff = arr[i] + arr[mid] - k;
                if (Math.abs(diff) < minDiff) {
                    minDiff = Math.abs(diff);
                    combinations = 1;
                } else if (Math.abs(diff) == minDiff) {
                    combinations++;
                }
                if (diff <= 0) start = mid + 1;
                else end = mid - 1;
            }
        }
        return combinations;
    }
}