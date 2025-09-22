// BOJ - 12339
// Problem Sheet - https://www.acmicpc.net/problem/12339

import java.util.*;
import java.io.*;

public class Main {

    private static final String FORMAT = "Case #%d: %d";
    private static final int LIMIT = 1_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] isFairAndSquare = new boolean[LIMIT + 1];
        int[] acc = new int[LIMIT + 1];
        for (int i=1 ; i<=LIMIT ; i++) {
            if (i * i <= LIMIT && isPalindrome(i) && isPalindrome(i * i)) {
                isFairAndSquare[i * i] = true;
            }
        }
        for (int i=1 ; i<=LIMIT ; i++) {
            acc[i] = acc[i - 1] + (isFairAndSquare[i] ? 1 : 0);
        }

        int t = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=t ; i++) {
            String[] row = br.readLine().split(" ");
            int a = Integer.parseInt(row[0]);
            int b = Integer.parseInt(row[1]);
            sb.append(String.format(FORMAT, i, acc[b] - acc[a - 1])).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static boolean isPalindrome(int n) {
        String origin = Integer.toString(n);
        String reverse = new StringBuilder(origin).reverse().toString();
        return origin.equals(reverse);
    }

}