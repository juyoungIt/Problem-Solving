// BOJ - 34554
// Problem Sheet - https://www.acmicpc.net/problem/34554

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (isPrimeNumber(1 + n)) {
                sb.append(1).append("\n").append(1).append(" ").append(1 + n);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static boolean isPrimeNumber(int n) {
        if (n == 1) return false;
        for (int i=2 ; i<n ; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
