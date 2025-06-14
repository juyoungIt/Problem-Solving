// BOJ - 26503
// Problem Sheet - https://www.acmicpc.net/problem/26503

import java.io.*;

public class Main {

    private static final String NOT_NEIGHBORS = "NOT NEIGHBORS";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i=0 ; i<n ; i++) {
            String[] row = br.readLine().split(" ");
            int a = Integer.parseInt(row[0]);
            int b = Integer.parseInt(row[1]);
            int c = Integer.parseInt(row[2]);
            int d = Integer.parseInt(row[3]);
            int numerator = Math.abs(a * d - c * b);
            int denominator = b * d;
            int[] reduced = reduceFraction(numerator, denominator);
            if (reduced[0] == 1) sb.append("1/").append(reduced[1]).append("\n");
            else sb.append(NOT_NEIGHBORS).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }

    private static int[] reduceFraction(int numerator, int denominator) {
        int gcd = getGCD(Math.abs(numerator), denominator);
        return new int[] { numerator / gcd, denominator / gcd };
    }

}