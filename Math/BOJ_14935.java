// BOJ - 14935
// Problem Sheet - https://www.acmicpc.net/problem/14935

import java.util.*;
import java.io.*;

public class Main {

    private static String x;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve() ? "FA" : "NFA");
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = br.readLine();
        br.close();
    }

    private static boolean solve() {
        Set<String> set = new HashSet<>();
        set.add(x);
        boolean result;
        String nextArg = x;
        while (true) {
            nextArg = f(nextArg);
            if (set.contains(nextArg)) {
                result = true;
                break;
            }
            set.add(nextArg);
        }
        return result;
    }

    private static String f(String x) {
        return Integer.toString((x.charAt(0) - '0') * x.length());
    }
}