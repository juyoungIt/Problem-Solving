// BOJ - 27294
// Problem Sheet - https://www.acmicpc.net/problem/27294

import java.io.*;

public class Main {

    private static int T, S;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        T = Integer.parseInt(row[0]);
        S = Integer.parseInt(row[1]);
        br.close();
    }

    private static int solve() {
        if (S == 0 && T >= 12 && T <= 16) {
            return 320;
        }
        return 280;
    }
}