// BOJ - 11441
// Problem Sheet - https://www.acmicpc.net/problem/11441

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] acc = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1 ; i<=n ; i++) {
            acc[i] = acc[i - 1] + Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        for (int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            sb.append(acc[x2] - acc[x1 - 1]).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}