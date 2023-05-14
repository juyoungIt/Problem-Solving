// BOJ - 1357
// Problem Sheet - https://www.acmicpc.net/problem/1357

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int numberA = Integer.parseInt(getReverseNumber(st.nextToken()));
        int numberB = Integer.parseInt(getReverseNumber(st.nextToken()));

        System.out.println(Integer.parseInt(getReverseNumber(Integer.toString(numberA+numberB))));

        bf.close();
        System.exit(0);
    }

    private static String getReverseNumber(String number) {
        StringBuilder sb = new StringBuilder(number);
        return sb.reverse().toString();
    }
}