// BOJ - 10406
// Problem Sheet - https://www.acmicpc.net/problem/10406

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int validPunchCount = 0;
        while (p-- > 0) {
            int punchHeight = Integer.parseInt(st.nextToken());
            if (w <= punchHeight && punchHeight <= n) {
                validPunchCount++;
            }
        }
        System.out.println(validPunchCount);
        br.close();
    }
}