// BOJ - 9663
// Problem Sheet - https://www.acmicpc.net/problem/9663

import java.io.*;

public class Main {

    private static int N;
    private static int[] queens;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        input();
        solve(0);
        System.out.println(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        queens = new int[N];
        br.close();
    }

    private static void solve(int r) {
        if (r == N) {
            answer++;
            return;
        }
        int count = 0;
        for (int i=0 ; i<N ; i++) {
            queens[r] = i;
            if (isPlaceable(r)) {
                solve(r + 1);
            }
        }
    }

    private static boolean isPlaceable(int r) {
        for (int i=0 ; i<r ; i++) {
            if (queens[r] == queens[i]) return false;
            if (r - i == Math.abs(queens[r] - queens[i])) return false;
        }
        return true;
    }
}
