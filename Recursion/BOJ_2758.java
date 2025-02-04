// BOJ - 2758
// Problem Sheet - https://www.acmicpc.net/problem/2758

import java.util.*;
import java.io.*;

public class Main {

    private static long[][] storage;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String[] row = br.readLine().split(" ");
            int n = Integer.parseInt(row[0]);
            int m = Integer.parseInt(row[1]);
            storage = new long[n + 1][m + 1];
            for (int i=0 ; i<=n ; i++) {
                Arrays.fill(storage[i], -1);
            }
            sb.append(solve(n, m)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static long solve(int i, int last) {
        if (last <= 0) return 0;
        if (i == 1) return last;
        if (storage[i][last] < 0) {
            storage[i][last] = solve(i - 1, last / 2) + solve(i, last - 1);
        }
        return storage[i][last];
    }
}