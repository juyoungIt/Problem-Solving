// BOJ - 2661
// Problem Sheet - https://www.acmicpc.net/problem/2661

import java.io.*;

public class Main {

    private static int N;
    private static int[] seq;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        input();
        solve(1, 0);
        for (int element : seq) {
            sb.append(element);
        }
        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        seq = new int[N];
        br.close();
    }

    private static void solve(int len, int lastElement) {
        // 1. Base Case
        if (len == N + 1) {
            return;
        }
        // 2. Recursive Case
        boolean insertFailed = true;
        for (int element=lastElement+1 ; element<=3 ; element++) {
            seq[len - 1] = element;
            if (isGoodSequence(len)) {
                insertFailed = false;
                solve(len + 1, 0);
                break;
            }
        }
        if (insertFailed) {
            solve(len - 1, seq[len - 2]);
        }
    }

    private static boolean isGoodSequence(int len) {
        for (int size=1 ; size<=len/2 ; size++) {
            if (!isGoodSequence(len, size)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isGoodSequence(int len, int size) {
        for (int i=0 ; i<size ; i++) {
            if (seq[len - 2 * size + i] != seq[len - size + i]) {
                return true;
            }
        }
        return false;
    }
}
