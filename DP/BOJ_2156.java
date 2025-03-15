// BOJ - 2156
// Problem Sheet - https://www.acmicpc.net/problem/2156

import java.io.*;

public class Main {

    private static int n;
    private static int[] wine;
    private static int[][] storage;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        wine = new int[n];
        for (int i=0 ; i<n ; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        storage = new int[3][n];
        br.close();
    }

    private static int solve() {
        storage[0][0] = 0;
        storage[1][0] = wine[0];
        storage[2][0] = wine[0];
        for (int i=1 ; i<n ; i++) {
            storage[0][i] = Math.max(storage[0][i - 1], Math.max(storage[1][i - 1], storage[2][i - 1]));
            storage[1][i] = storage[0][i - 1] + wine[i];
            storage[2][i] = storage[1][i - 1] + wine[i];
        }
        return Math.max(storage[0][n - 1], Math.max(storage[1][n - 1], storage[2][n - 1]));
    }
}
