// BOJ - 9095
// Problem Sheet - https://www.acmicpc.net/problem/9095

import java.io.*;

public class Main {

    private static int T;
    private static int[] cases;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        input();
        for (int c : cases) {
            count = 0;
            solve(0, c);
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        cases = new int[T];
        for (int i=0 ; i<T ; i++) {
            cases[i] = Integer.parseInt(br.readLine());
        }
        br.close();
    }

    private static void solve(int acc, int target) {
        if (acc >= target) {
            if (acc == target) {
                count++;
            }
            return;
        }
        for (int i=1 ; i<=3 ; i++) {
            if (acc == 0) solve(acc + i, target);
            else solve(acc + i, target);
        }
    }
}