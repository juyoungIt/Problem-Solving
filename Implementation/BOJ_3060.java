// BOJ - 3060
// Problem Sheet - https://www.acmicpc.net/problem/3060

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());
            st = new StringTokenizer(br.readLine());
            long sum = 0;
            for (int i=0 ; i<6 ; i++) {
                sum += Long.parseLong(st.nextToken());
            }
            int day = 1;
            while (sum <= n) {
                sum *= 4;
                day++;
            }
            sb.append(day).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
