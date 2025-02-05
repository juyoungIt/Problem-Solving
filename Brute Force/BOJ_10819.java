// BOJ - 10819
// Problem Sheet - https://www.acmicpc.net/problem/10819

import java.io.*;

public class Main {

    private static int N;
    private static int[] A;
    private static boolean[] isUsed;
    private static int[] seq;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        input();
        solve(0);
        System.out.println(max);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<N ; i++) {
            A[i] = Integer.parseInt(row[i]);
        }
        seq = new int[N];
        isUsed = new boolean[N];
        br.close();
    }

    private static void solve(int size) {
        if (size == N) {
            max = Math.max(max, getSequenceValue());
            return;
        }
        for (int i=0 ; i<N ; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                seq[size] = A[i];
                solve(size + 1);
                isUsed[i] = false;
            }
        }
    }

    private static int getSequenceValue() {
        int sequenceValue = 0;
        for (int i=0 ; i<N-1 ; i++) {
            sequenceValue += Math.abs(seq[i] - seq[i + 1]);
        }
        return sequenceValue;
    }
}