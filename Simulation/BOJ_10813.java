// BOJ - 10813
// Problem Sheet - https://www.acmicpc.net/problem/10813

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

        for (int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            swap(buckets, a, b);
        }

        for (int i=1 ; i<=n ; i++) {
            sb.append(buckets[i]).append(" ");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static void swap(int[] buckets, int a, int b) {
        int tmp = buckets[a];
        buckets[a] = buckets[b];
        buckets[b] = tmp;
    }
}