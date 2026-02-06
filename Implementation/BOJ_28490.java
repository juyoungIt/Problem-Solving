// BOJ - 28490
// Problem Sheet - https://www.acmicpc.net/problem/28490

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int max = 0;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            max = Math.max(max, h * w);
        }
        System.out.println(max);
        br.close();
    }
}
