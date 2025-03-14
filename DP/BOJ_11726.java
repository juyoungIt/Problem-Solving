// BOJ - 11726
// Problem Sheet - https://www.acmicpc.net/problem/11726

import java.io.*;

public class Main {

    private static int[] storage;
    private static final int DIVIDER = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        storage = new int[n + 1];
        System.out.println(solve(n));
        br.close();
    }

    private static int solve(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (storage[n] == 0) {
            storage[n] = (solve(n - 2) + solve(n - 1)) % DIVIDER;
        }
        return storage[n];
    }
}
