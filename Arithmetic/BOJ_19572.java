// BOJ - 19572
// Problem Sheet - https://www.acmicpc.net/problem/19572

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d1 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        int d3 = Integer.parseInt(st.nextToken());

        double a = (double) (d1 + d2 - d3) / 2;
        double b = d1 - a;
        double c = d2 - a;

        if (a > 0 && b > 0 && c > 0) {
            System.out.printf("%d\n%.1f %.1f %.1f\n", 1, a, b, c);
        } else {
            System.out.println(-1);
        }

        br.close();
        System.exit(0);
    }
}