// BOJ - 7281
// Problem Sheet - https://www.acmicpc.net/problem/7281

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int maxDownTime = 0, curDownTime = 0;
        int testCount = n;
        int[] prev = new int[2];
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n + 1 == testCount) {
                prev[0] = t;
                prev[1] = m;
                continue;
            }
            curDownTime += t - prev[0];
            if (m == 1) {
                maxDownTime = Math.max(maxDownTime, curDownTime);
                curDownTime = 0;
            }
            prev[0] = t;
            prev[1] = m;
        }
        maxDownTime = Math.max(maxDownTime, curDownTime);
        System.out.println(maxDownTime);
        br.close();
    }
}
