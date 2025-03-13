// BOJ - 2748
// Problem Sheet - https://www.acmicpc.net/problem/2748

import java.io.*;

public class Main {

    private static int n;
    private static long[] fibo;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        fibo = new long[n + 1];
        br.close();
    }

    private static long solve() {
        fibo[1] = 1;
        for (int i=2 ; i<=n ; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        return fibo[n];
    }
}
