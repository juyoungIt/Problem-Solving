// BOJ - 1074
// Problem Sheet - https://www.acmicpc.net/problem/1074

import java.io.*;

public class Main {

    private static int N;
    private static int r, c;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        input();
        solve(N, r, c);
        System.out.println(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        N = Integer.parseInt(row[0]);
        r = Integer.parseInt(row[1]);
        c = Integer.parseInt(row[2]);
        br.close();
    }

    private static void solve(int n, int r, int c) {
        int boardSize = 1 << n;
        int mid = boardSize / 2;
        if (n == 0) return;
        if (r < mid && c < mid) {
            solve(n - 1, r, c);
        } else if (r < mid) {
            answer += mid * mid;
            solve(n - 1, r, c - mid);
        } else if (c < mid) {
            answer += mid * mid * 2;
            solve(n - 1, r - mid, c);
        } else {
            answer += mid * mid * 3;
            solve(n - 1, r - mid, c - mid);
        }
    }
}
