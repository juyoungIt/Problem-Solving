// BOJ - 33541
// Problem Sheet - https://www.acmicpc.net/problem/33541

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        while (++x < 10_000) {
            int pow = (int) Math.pow(getSum(x), 2);
            if (pow == x) {
                System.out.println(x);
                return;
            }
        }
        System.out.println(-1);
        br.close();
    }

    private static int getSum(int year) {
        return year / 100 + year % 100;
    }
}
