// BOJ - 17390
// Problem Sheet - https://www.acmicpc.net/problem/17390

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] seq = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i=1 ; i<=n ; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(seq);

        int[] acc = new int[n + 1];
        for (int i=1 ; i<=n ; i++) {
            acc[i] = acc[i - 1] + seq[i];
        }

        for (int i=0 ; i<q ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(acc[end] - acc[start - 1]).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}