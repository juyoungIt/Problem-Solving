// BOJ - 30804
// Problem Sheet - https://www.acmicpc.net/problem/30804

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 1, end = n;
        int answer = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isValid(arr, mid)) {
                start = mid + 1;
                answer = mid;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(answer);
        br.close();
    }

    private static boolean isValid(int[] arr, int size) {
        int[] counts = new int[10];
        for (int i=0 ; i<size ; i++) {
            counts[arr[i]]++;
        }
        if (kind(counts) <= 2) return true;
        int start = 0, end = size;
        while (end < arr.length) {
            counts[arr[start++]]--;
            counts[arr[end++]]++;
            if (kind(counts) <= 2) return true;
        }
        return false;
    }

    private static int kind(int[] arr) {
        int kind = 0;
        for (int i=0 ; i<arr.length ; i++) {
            if (arr[i] > 0) {
                kind++;
            }
        }
        return kind;
    }
}
