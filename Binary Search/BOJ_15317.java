// BOJ - 15317
// Problem Sheet - https://www.acmicpc.net/problem/15317

import java.util.*;
import java.io.*;

public class Main {

    private static int N, M, X;
    private static int[] C, S;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        N = Integer.parseInt(row[0]);
        M = Integer.parseInt(row[1]);
        X = Integer.parseInt(row[2]);
        C = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        S = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        br.close();
    }

    private static long solve() {
        int start = 0, end = Math.min(N, M);
        long assignCount = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (getMinAssignCount(mid) <= X) {
                assignCount = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return assignCount;
    }

    private static long getMinAssignCount(int assignSize) {
        long assignCount = 0;
        for (int i=0 ; i<assignSize ; i++) {
            assignCount += Math.max(C[i] - S[M - assignSize + i], 0);
        }
        return assignCount;
    }

}
