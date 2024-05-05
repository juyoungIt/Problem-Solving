// BOJ - 26145
// Problem Sheet - https://www.acmicpc.net/problem/26145

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] benefits = new int[n + m];
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++) {
            benefits[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0 ; j<n+m ; j++) {
                int benefit = Integer.parseInt(st.nextToken());
                benefits[i] -= benefit;
                benefits[j] += benefit;
            }
        }

        for (int benefit : benefits) {
            sb.append(benefit).append(" ");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}