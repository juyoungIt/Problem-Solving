// BOJ - 29567
// Problem Sheet - https://www.acmicpc.net/problem/29567

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] digits = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int M = 0, m = 0;
        int len = digits.length;
        for (int i=0 ; i<len ; i++) {
            M += digits[i] * (int) Math.pow(10, i);
            m += digits[i] * (int) Math.pow(10, len - 1 - i);
        }
        String result = Integer.toString(M - m);
        StringBuilder sb = new StringBuilder();
        sb.append("0".repeat(Math.max(0, digits.length - result.length())));
        for (int i=0 ; i<result.length() ; i++) {
            sb.append(result.charAt(i));
        }
        System.out.println(sb);
        br.close();
    }
}