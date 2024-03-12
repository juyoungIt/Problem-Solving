// BOJ - 25591
// Problem Sheet - https://www.acmicpc.net/problem/25591

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int operandA = Integer.parseInt(st.nextToken());
        int operandB = Integer.parseInt(st.nextToken());
        int a = 100 - operandA;
        int b = 100 - operandB;
        int c = 100 - (a + b);
        int d = a * b;

        int q = d / 100;
        int r = d % 100;

        System.out.printf("%d %d %d %d %d %d\n", a, b, c, d, q, r);
        if (Integer.toString(d).length() > 2) {
            c += q;
            d = r;
        }
        System.out.printf("%d %d\n%n", c, d);

        br.close();
        System.exit(0);
    }
}