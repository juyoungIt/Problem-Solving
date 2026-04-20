// BOJ - 33868
// Problem Sheet - https://www.acmicpc.net/problem/33868

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int maxT = 0, minB = 5_001;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            maxT = Math.max(maxT, t);
            minB = Math.min(minB, b);
        }
        System.out.println((maxT * minB) % 7 + 1);
        br.close();
    }
}
