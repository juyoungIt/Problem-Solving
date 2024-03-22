// BOJ - 23813
// Problem Sheet - https://www.acmicpc.net/problem/23813

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        long totalSum = 0;
        for (int i=0 ; i<n.length() ; i++) {
            n = getRotatedNumber(n);
            totalSum += Long.parseLong(n);
        }

        System.out.println(totalSum);

        br.close();
        System.exit(0);
    }

    private static String getRotatedNumber(String number) {
        StringBuilder sb = new StringBuilder();
        String[] digits = number.split("");
        sb.append(digits[digits.length - 1]);
        for (int i=0 ; i<digits.length-1 ; i++) {
            sb.append(digits[i]);
        }
        return sb.toString();
    }
}