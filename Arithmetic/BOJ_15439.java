// BOJ - 15439
// Problem Sheet - https://www.acmicpc.net/problem/15439

import java.io.*;

public class Main {

    private static int N;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();
    }

    private static int solve() {
        return N * (N - 1);
    }
}
