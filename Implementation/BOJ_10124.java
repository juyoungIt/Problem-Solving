// BOJ - 10214
// Problem Sheet - https://www.acmicpc.net/problem/10214

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int ySum = 0, kSum = 0;
            for (int i=0 ; i<9 ; i++) {
                st = new StringTokenizer(br.readLine());
                ySum += Integer.parseInt(st.nextToken());
                kSum += Integer.parseInt(st.nextToken());
            }
            if (ySum == kSum) sb.append("Draw").append("\n");
            else if (ySum > kSum) sb.append("Yonsei").append("\n");
            else sb.append("Korea").append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
