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
        storage[1] = 1;
        if (n >= 2) storage[2] = 2;
        for (int i=3 ; i<=n ; i++) {
            storage[i] = (storage[i - 2] + storage[i - 1]) % DIVIDER;
        }
        return storage[n];
    }
}
