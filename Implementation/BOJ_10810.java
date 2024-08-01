// BOJ - 10810
// Problem Sheet - https://www.acmicpc.net/problem/10810

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
        for (int x=0 ; x<m ; x++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            for (int y=i ; y<=j ; y++) {
                buckets[y] = k;
            }
        }

        for (int x=1 ; x<=n  ; x++) {
            sb.append(buckets[x]).append(" ");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}