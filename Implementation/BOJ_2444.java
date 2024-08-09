// BOJ - 2444
// Problem Sheet - https://www.acmicpc.net/problem/2444

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=n ; i++) {
            sb.append(" ".repeat(Math.max(0, n - i)));
            sb.append("*".repeat(Math.max(0, 2 * i - 1))).append("\n");
        }
        for (int i=n-1 ; i>=0 ; i--) {
            sb.append(" ".repeat(Math.max(0, n - i)));
            sb.append("*".repeat(Math.max(0, 2 * i - 1))).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}