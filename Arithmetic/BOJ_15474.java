// BOJ - 15474
// Problem Sheet - https://www.acmicpc.net/problem/15474

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int totalPriceA = b * ((n / a) + (n % a > 0 ? 1 : 0));
        int totalPriceB = d * ((n / c) + (n % c > 0 ? 1 : 0));
        System.out.println(Math.min(totalPriceA, totalPriceB));

        br.close();
        System.exit(0);
    }
}