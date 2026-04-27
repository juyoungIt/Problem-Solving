// BOJ - 5612
// Problem Sheet - https://www.acmicpc.net/problem/5612

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int min = Integer.MAX_VALUE, max = m;
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int in = Integer.parseInt(st.nextToken());
            int out = Integer.parseInt(st.nextToken());
            m = m + in - out;
            min = Math.min(min, m);
            max = Math.max(max, m);
        }
        System.out.println(min < 0 ? 0 : max);
        br.close();
    }
}
