// BOJ - 16693
// Problem Sheet - https://www.acmicpc.net/problem/16693

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a1 = Integer.parseInt(st.nextToken());
        int p1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        double areaPerDollarA = (double) a1 / p1;
        double areaPerDollarB = (double) r1 * r1 * Math.PI / p2;

        if (areaPerDollarA > areaPerDollarB) {
            System.out.println("Slice of pizza");
        } else {
            System.out.println("Whole pizza");
        }

        br.close();
        System.exit(0);
    }
}