// BOJ - 2609
// Problem Sheet - https://www.acmicpc.net/problem/2609

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int numberA = Integer.parseInt(st.nextToken());
        int numberB = Integer.parseInt(st.nextToken());

        int gcd = getGCD(numberA, numberB);
        int lcm = getLCM(numberA, numberB, gcd);

        System.out.println(gcd);
        System.out.println(lcm);

        bf.close();
        System.exit(0);
    }

    private static int getGCD(int numberA, int numberB) {
        int divider;
        while(numberB > 0) {
            divider = numberA % numberB;
            numberA = numberB;
            numberB = divider;
        }
        return numberA;
    }

    private static int getLCM(int numberA, int numberB, int gcd) {
        return numberA * numberB / gcd;
    }
}