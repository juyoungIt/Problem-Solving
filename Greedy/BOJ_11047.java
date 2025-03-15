// BOJ - 11047
// Problem Sheet - https://www.acmicpc.net/problem/11047

import java.io.*;

public class Main {

    private static int N, K;
    private static int[] coins;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        coins = new int[N];
        for (int i=0 ; i<N ; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        br.close();
    }

    private static int solve() {
        int coinCount = 0;
        for (int i=N-1 ; i>=0 ; i--) {
            coinCount += K / coins[i];
            K %= coins[i];
        }
        return coinCount;
    }
}
