// BOJ - 28289
// Problem Sheet - https://www.acmicpc.net/problem/28289

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] count = new int[5];
        int p = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (p-- > 0) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (g > 1) {
                count[c]++;
            } else {
                count[0]++;
            }
        }
        sb.append(count[1] + count[2]).append("\n")
                .append(count[3]).append("\n")
                .append(count[4]).append("\n")
                .append(count[0]);
        System.out.println(sb);
        br.close();
    }
}
