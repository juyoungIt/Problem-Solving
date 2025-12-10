// BOJ - 5523
// Problem Sheet - https://www.acmicpc.net/problem/5523

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] wc = new int[2];
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a > b) wc[0]++;
            if (a < b) wc[1]++;
        }
        System.out.println(wc[0] + " " + wc[1]);
        br.close();
    }
}
