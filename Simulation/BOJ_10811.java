// BOJ - 10811
// Problem Sheet - https://www.acmicpc.net/problem/10811

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] buckets = new int[n + 1];
        for (int i=1 ; i<=n ; i++) {
            buckets[i] = i;
        }

        for (int x=0 ; x<m ; x++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            reverse(buckets, i, j);
        }

        for (int i=1 ; i<=n ; i++) {
            sb.append(buckets[i]).append(" ");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static void reverse (int[] arr, int i, int j) {
        for (int x=i ; x<=(i+j)/2 ; x++) {
            swap(arr, x, j + i - x);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}