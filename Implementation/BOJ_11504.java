// BOJ - 11504
// Problem Sheet - https://www.acmicpc.net/problem/11504

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int x = 0, y = 0;
            st = new StringTokenizer(br.readLine());
            for (int i=m-1 ; i>=0 ; i--) {
                x += Integer.parseInt(st.nextToken()) * Math.pow(10, i);
            }
            st = new StringTokenizer(br.readLine());
            for (int i=m-1 ; i>=0 ; i--) {
                y += Integer.parseInt(st.nextToken()) * Math.pow(10, i);
            }
            st = new StringTokenizer(br.readLine());
            int[] b = new int[n];
            for (int i=0 ; i<n ; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            int count = 0;
            for (int i=0 ; i<n ; i++) {
                int v = 0;
                int idx = i - 1;
                for (int j=m-1 ; j>=0 ; j--) {
                    idx = (++idx) % n;
                    v += b[idx] * Math.pow(10, j);
                }
                if (x <= v && v <= y) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
