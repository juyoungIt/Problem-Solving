// BOJ - 14476
// Problem Sheet - https://www.acmicpc.net/problem/14476

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] numbers = new int[N+2];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=1 ; i<=N ; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] leftGCD = new int[N+2];
        int[] rightGCD = new int[N+2];
        leftGCD[1] = numbers[1];
        rightGCD[N] = numbers[N];
        for(int i=2 ; i<=N ; i++) {
            leftGCD[i] = getGCD(Math.min(leftGCD[i-1], numbers[i]), Math.max(leftGCD[i-1], numbers[i]));
            rightGCD[N-i+1] = getGCD(Math.min(rightGCD[N-i+2], numbers[N-i+1]), Math.max(rightGCD[N-i+2], numbers[N-i+1]));
        }

        int maxGCD = -1;
        int subtract = -1;
        for(int i=1 ; i<=N ; i++) {
            int gcd = getGCD(leftGCD[i-1], rightGCD[i+1]);
            if(numbers[i] % gcd > 0 && gcd > maxGCD) {
                maxGCD = gcd;
                subtract = numbers[i];
            }
        }

        if(maxGCD > 0) {
            System.out.println(maxGCD + " " + subtract);
        } else {
            System.out.println(-1);
        }

        bf.close();
        System.exit(0);
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
}