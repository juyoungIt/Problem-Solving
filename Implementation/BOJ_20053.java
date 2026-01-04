// BOJ - 20053
// Problem Sheet - https://www.acmicpc.net/problem/20053

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int min = 1_000_001, max = -1_000_000;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int e = Integer.parseInt(st.nextToken());
                min = Math.min(min, e);
                max = Math.max(max, e);
            }
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
