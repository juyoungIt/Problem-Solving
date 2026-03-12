// BOJ - 13225
// Problem Sheet - https://www.acmicpc.net/problem/13225

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int c = Integer.parseInt(br.readLine());
        while (c-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(n).append(" ").append(getDivisorCount(n)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int getDivisorCount(int n) {
        int count = 1;
        for (int i=2 ; i<=n ; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }
}
