// BOJ - 12871
// Problem Sheet - https://www.acmicpc.net/problem/12871

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        int a = Math.max(s.length(), t.length());
        int b = Math.min(s.length(), t.length());
        int lcm = getLCM(a, b, getGCD(a, b));

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i=0 ; i<lcm/s.length() ; i++) sb1.append(s);
        for (int i=0 ; i<lcm/t.length() ; i++) sb2.append(t);

        System.out.println(sb1.toString().contentEquals(sb2) ? 1 : 0);
        br.close();
    }

    private static int getGCD(int a, int b) {
        int divider;
        while(b > 0) {
            divider = a % b;
            a = b;
            b = divider;
        }
        return a;
    }

    private static int getLCM(int a, int b, int gcd) {
        return a * b / gcd;
    }
}