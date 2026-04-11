// BOJ - 33990
// Problem Sheet - https://www.acmicpc.net/problem/33990

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int answer = -1;
        int minDiff = 512;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int sum = a + b + c;
            if (sum >= 512) {
                int diff = sum - 512;
                if (minDiff > diff) {
                    minDiff = diff;
                    answer = sum;
                }
            }
        }
        System.out.println(answer);
        br.close();
    }
}