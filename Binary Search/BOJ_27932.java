// BOJ - 27932
// Problem Sheet - https://www.acmicpc.net/problem/27932

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 2];
        st = new StringTokenizer(br.readLine());
        for (int i=1 ; i<=n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[0] = arr[1];
        arr[n + 1] = arr[n];
        int start = 0, end = 1_000_000_000;
        int opt = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int tiredCount = getTiredCount(arr, mid);
            if (tiredCount <= k) {
                opt = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(opt);
        br.close();
    }

    private static int getTiredCount(int[] arr, int k) {
        int count = 0;
        for (int i=1 ; i<arr.length-1 ; i++) {
            int left = Math.abs(arr[i] - arr[i - 1]);
            int right = Math.abs(arr[i] - arr[i + 1]);
            if (left > k || right > k) count++;
        }
        return count;
    }
}
