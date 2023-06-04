// BOJ - 14490
// Problem Sheet - https://www.acmicpc.net/problem/14490

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] numbers = bf.readLine().split(":");

        int numberA = Integer.parseInt(numbers[0]);
        int numberB = Integer.parseInt(numbers[1]);
        int gcd = getGCD(numberA, numberB);

        sb.append(numberA/gcd)
                .append(":")
                .append(numberB/gcd);

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static int getGCD(int numberA, int numberB) {
        if(numberB == 0) {
            return numberA;
        }
        return getGCD(numberB, numberA%numberB);
    }
}