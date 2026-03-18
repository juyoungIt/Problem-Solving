// BOJ - 2980
// Problem Sheet - https://www.acmicpc.net/problem/2980

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int ct = 0, cl = 0;
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            // 1. 현재 위치에서 신호등까지 가는 데 걸리는 시간
            ct += d - cl;
            cl = d;
            // 2. 신호등에서 대기해야하는 시간
            int t = ct % (r + g);
            ct += (t > r ? 0 : r - t);
        }
        ct += (l - cl);
        System.out.println(ct);
        br.close();
    }
}
