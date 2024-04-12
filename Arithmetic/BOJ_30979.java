// BOJ - 16283
// Problem Sheet - https://www.acmicpc.net/problem/16283

import java.util.*;
import java.io.*;

public class Main {

    private static final String messageWhenCaseHappy = "Padaeng_i Happy";
    private static final String messageWhenCaseCry = "Padaeng_i Cry";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int candySum = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sum();

        if (candySum >= t) {
            System.out.println(messageWhenCaseHappy);
        } else {
            System.out.println(messageWhenCaseCry);
        }

        br.close();
        System.exit(0);
    }
}