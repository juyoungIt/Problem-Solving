// BOJ - 15658
// Problem Sheet - https://www.acmicpc.net/problem/15658

import java.io.*;

public class Main {

    private static int N;
    private static int[] operands;
    private static int[] operators;
    private static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        solve(0, operands[0]);
        System.out.printf("%d\n%d", max, min);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        operands = new int[N];
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<N ; i++) {
            operands[i] = Integer.parseInt(row[i]);
        }
        row = br.readLine().split(" ");
        operators = new int[4];
        for (int i=0 ; i<4 ; i++) {
            operators[i] = Integer.parseInt(row[i]);
        }
        br.close();
    }

    private static void solve(int count, int acc) {
        if (count == N-1) {
            min = Math.min(min, acc);
            max = Math.max(max, acc);
            return;
        }
        for (int i=0 ; i<4 ; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                int newAcc = acc;
                if (i == 0) newAcc += operands[count + 1];
                else if (i == 1) newAcc -= operands[count + 1];
                else if (i == 2) newAcc *= operands[count + 1];
                else newAcc /= operands[count + 1];
                solve(count + 1, newAcc);
                operators[i]++;
            }
        }
    }
}