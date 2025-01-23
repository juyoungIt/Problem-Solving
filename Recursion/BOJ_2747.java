// BOJ - 2747
// Problem Sheet - https://www.acmicpc.net/problem/2747

import java.io.*;

public class Main {

    private static int n;
    private static int[] cache;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        br.close();
    }

    private static int solve() {
        cache = new int[n + 1];
        return fibo(n);
    }

    private static int fibo(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else {
            if (cache[n] > 0) return cache[n];
            cache[n] = fibo(n - 2) + fibo(n - 1);
            return cache[n];
        }
    }
}