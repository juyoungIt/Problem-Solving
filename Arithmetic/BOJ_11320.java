// BOJ - 4714
// Problem Sheet - https://www.acmicpc.net/problem/4714

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append((int) Math.ceil(Math.pow(a, 2) / Math.pow(b, 2))).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static double getTriangleArea(int side) {
        return Math.pow(side, 2) * Math.sqrt(3) / 4;
    }
}