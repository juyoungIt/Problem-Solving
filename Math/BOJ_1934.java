// BOJ - 1934
// Problem Sheet - https://www.acmicpc.net/problem/1934

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
            int gcd = getGCD(Math.min(a, b), Math.max(a, b));
            sb.append(getLCM(Math.min(a, b), Math.max(a, b), gcd)).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static int getGCD(int numberA, int numberB) {
        if(numberB == 0) {
            return numberA;
        }
        return getGCD(numberB, numberA%numberB);
    }

    private static int getLCM(int numberA, int numberB, int gcd) {
        return numberA * numberB / gcd;
    }
}